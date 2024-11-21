package oo.observer.msg;

import oo.Klass;
import oo.Student;

public class UpdateKlassLeaderMessage extends Message{
    private final Klass klass;
    private final Student leader;

    public UpdateKlassLeaderMessage(Klass klass, Student leader)
    {
        this.klass = klass;
        this.leader = leader;
    }

    public Klass getKlass() {
        return klass;
    }

    public Student getLeader() {
        return leader;
    }
}
