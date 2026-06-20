package fr.vbaheux.mtengine.entity.old;

import lombok.NonNull;

import java.util.EnumSet;
import java.util.List;

public record Scale(@NonNull NoteEnum tonic, @NonNull ScaleType type) {

    public EnumSet<IntervalEnum> getIntervals() {
        return type.getIntervals();
    }

    public List<NoteEnum> getNotes() {
        return type.getIntervals().stream().map(tonic::addInterval).toList();
    }
}
