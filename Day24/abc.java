import java.util.Map;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.csv.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;

class IPLMatch {
    public int match_id;
    public String team1;
    public String team2;
    public Map<String, Integer> score;
    public String winner;
    public String player_of_match;
}

public class IPLCensorAnalyzer {

    // Apply censorship rules to one match
    private static IPLMatch censor(IPLMatch match) {
        match.team1 = maskTeam(match.team1);
        match.team2 = maskTeam(match.team2);
        match.winner = maskTeam(match.winner);
        match.player_of_match = "REDACTED";

        // Mask team names inside score map
        Map<String, Integer> newScore = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : match.score.entrySet()) {
            newScore.put(maskTeam(entry.getKey()), entry.getValue());
        }
        match.score = newScore;
        return match;
    }

    private static String maskTeam(String teamName) {
        String[] parts = teamName.split(" ", 2);
        return parts[0] + " ***";
    }

    // JSON processing
    public static void processJson(String inputPath, String outputPath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<IPLMatch> matches = mapper.readValue(new File(inputPath), new TypeReference<>() {});

        List<IPLMatch> censoredMatches = new ArrayList<>();
        for (IPLMatch match : matches) {
            censoredMatches.add(censor(match));
        }

        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputPath), censoredMatches);
        System.out.println("Censored JSON written to " + outputPath);
    }

    // CSV processing
    public static void processCsv(String inputPath, String outputPath) throws IOException {
        Reader in = Files.newBufferedReader(Paths.get(inputPath));
        CSVParser parser = new CSVParser(in, CSVFormat.DEFAULT.withFirstRecordAsHeader());
        List<CSVRecord> records = parser.getRecords();

        BufferedWriter out = Files.newBufferedWriter(Paths.get(outputPath));
        CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT.withHeader("match_id", "team1", "team2", "score_team1", "score_team2", "winner", "player_of_match"));

        for (CSVRecord record : records) {
            int matchId = Integer.parseInt(record.get("match_id"));
            String team1 = maskTeam(record.get("team1"));
            String team2 = maskTeam(record.get("team2"));
            int score1 = Integer.parseInt(record.get("score_team1"));
            int score2 = Integer.parseInt(record.get("score_team2"));
            String winner = maskTeam(record.get("winner"));
            String player = "REDACTED";

            printer.printRecord(matchId, team1, team2, score1, score2, winner, player);
        }

        parser.close();
        printer.close();
        System.out.println("Censored CSV written to " + outputPath);
    }

    public static void main(String[] args) throws Exception {
        processJson("ipl_input.json", "ipl_censored.json");
        processCsv("ipl_input.csv", "ipl_censored.csv");
    }
}

