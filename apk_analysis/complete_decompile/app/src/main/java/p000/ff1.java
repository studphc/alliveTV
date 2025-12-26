package p000;

import com.google.common.base.Equivalence;
import com.google.common.base.Preconditions;
import com.google.common.collect.MapMaker;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

/* loaded from: classes.dex */
public final class ff1 extends xe1 {
    private static final long serialVersionUID = 3;

    private void readObject(ObjectInputStream objectInputStream) {
        boolean z;
        boolean z2;
        objectInputStream.defaultReadObject();
        MapMaker initialCapacity = new MapMaker().initialCapacity(objectInputStream.readInt());
        if1 if1Var = initialCapacity.f14733d;
        boolean z3 = false;
        if (if1Var == null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "Key strength was already set to %s", if1Var);
        if1 if1Var2 = this.f28523a;
        initialCapacity.f14733d = (if1) Preconditions.checkNotNull(if1Var2);
        gf1 gf1Var = if1.f18394a;
        if (if1Var2 != gf1Var) {
            initialCapacity.f14730a = true;
        }
        if1 if1Var3 = initialCapacity.f14734e;
        if (if1Var3 == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkState(z2, "Value strength was already set to %s", if1Var3);
        if1 if1Var4 = this.f28524b;
        initialCapacity.f14734e = (if1) Preconditions.checkNotNull(if1Var4);
        if (if1Var4 != gf1Var) {
            initialCapacity.f14730a = true;
        }
        Equivalence equivalence = initialCapacity.f14735f;
        if (equivalence == null) {
            z3 = true;
        }
        Preconditions.checkState(z3, "key equivalence was already set to %s", equivalence);
        initialCapacity.f14735f = (Equivalence) Preconditions.checkNotNull(this.f28525c);
        initialCapacity.f14730a = true;
        this.f28527e = initialCapacity.concurrencyLevel(this.f28526d).makeMap();
        while (true) {
            Object readObject = objectInputStream.readObject();
            if (readObject == null) {
                return;
            }
            this.f28527e.put(readObject, objectInputStream.readObject());
        }
    }

    private Object readResolve() {
        return this.f28527e;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.f28527e.size());
        for (Map.Entry entry : this.f28527e.entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
        objectOutputStream.writeObject(null);
    }
}
