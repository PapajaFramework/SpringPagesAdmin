package org.papaja.adminfly.shared.data;

import java.util.HashSet;
import java.util.Set;

import static java.util.Objects.*;

public class AdminFlyModules {

    public Set<Module> getModules() {
        return Holder.INSTANCE.getModules();
    }

    public static void addModule(String name, String path) {
        Holder.INSTANCE.modules.add(new Module(name, path));
    }

    public enum Holder {

        INSTANCE;

        private Set<Module> modules;

        Holder() {
            modules = new HashSet<>();
        }

        public void addModule(String name, String path) {
            modules.add(new Module(name, path));
        }

        public Set<Module> getModules() {
            return modules;
        }

    }

    public static class Module {

        private String name;
        private String path;

        public Module(String name, String path) {
            this.name = name;
            this.path = path;
        }

        public String getName() {
            return name;
        }

        public String getPath() {
            return path;
        }

        @Override
        public int hashCode() {
            return hash(name, path);
        }
    }

}
