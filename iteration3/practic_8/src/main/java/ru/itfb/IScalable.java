package ru.itfb;

import org.jetbrains.annotations.NotNull;

public interface IScalable {
    @NotNull
    Integer getScale();

    void setScale(@NotNull Integer scale);
}
