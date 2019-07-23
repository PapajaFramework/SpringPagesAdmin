package org.papaja.adminfly.data;

public class AvailableThemes {

    public Themes[] getThemes() {
        return Themes.values();
    }

    public enum Themes {

        COSMO("cosmo", "Cosmo"),
        FLATLY("flatly", "Flatly"),
        JOURNAL("journal", "Journal"),
        LUMEN("lumen", "Lumen"),
        MATERIA("materia", "Materia"),
        MINTY("minty", "Minty"),
        PULSE("pulse", "Pulse"),
        SANDSTONE("sandstone", "SandStone"),
        SIMPLEX("simplex", "Simplex"),
        SLATE("slate", "Slate"),
        UNITED("united", "United (Ubuntu)"),
        YETI("yeti", "Yeti");

        private String name;
        private String label;

        Themes(String name, String label) {
            this.name = name;
            this.label = label;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

    }

}

