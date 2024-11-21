package oo.observer;

import oo.Klass;
import oo.Student;

public interface KlassObserver {
    void updateKlassLeader(Klass klass, Student leader);
}
