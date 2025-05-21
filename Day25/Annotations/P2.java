class LegacyAPI {

    @Deprecated
    public void oldFeature() {
        System.out.println("This is an old feature.");
    }

    public void newFeature() {
        System.out.println("This is a new feature.");
    }

    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature(); // Will show a deprecation warning
        api.newFeature();
    }
}
