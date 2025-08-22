package org.rpg.project.core.interfaces;

import org.rpg.project.core.enums.MagicType;

public interface Magic {
    String getName();
    int getLevel();
    MagicType getMagicStyle();
    int getManaCost();
}


