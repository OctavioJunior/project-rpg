package org.rpg.project.interfaces;

import org.rpg.project.enums.MagicType;

public interface Magic {
    String getName();
    int getLevel();
    MagicType getMagicStyle();
    int getManaCost();
}


