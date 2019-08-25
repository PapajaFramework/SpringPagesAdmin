package org.papaja.adminfly.module.mdbv.shared.drawer;

import org.papaja.adminfly.common.util.Drawer;
import org.papaja.adminfly.common.util.drawer.Base64Drawer;
import org.papaja.adminfly.common.util.drawer.ListDrawer;
import org.papaja.adminfly.common.util.drawer.MapDrawer;
import org.papaja.adminfly.common.util.drawer.RawDrawer;
import org.papaja.adminfly.common.util.function.Function;
import org.papaja.adminfly.module.mdbv.mysql.entity.SourcePath;

import java.util.EnumMap;
import java.util.Map;

import static org.papaja.adminfly.module.mdbv.mysql.entity.SourcePath.Type.*;

final public class DrawerFactory implements Function<SourcePath.Type, Drawer> {

    private static final Map<SourcePath.Type, Drawer> DRAWERS = new EnumMap<>(SourcePath.Type.class);

    static {
        DRAWERS.put(BASE64, new Base64Drawer());
        DRAWERS.put(RAW, new RawDrawer());
        DRAWERS.put(LIST, new ListDrawer());
        DRAWERS.put(MAP, new MapDrawer());
    }

    @Override
    public Drawer apply(SourcePath.Type type) {
        return DRAWERS.get(type);
    }

    public Drawer get(SourcePath.Type type) {
        return apply(type);
    }

}
