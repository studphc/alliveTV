package p000;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

/* loaded from: classes.dex */
public final class s13 extends ObjectInputStream {
    @Override // java.io.ObjectInputStream
    public final Class resolveClass(ObjectStreamClass objectStreamClass) {
        Class<?> cls = Class.forName(objectStreamClass.getName(), false, s13.class.getClassLoader());
        if (cls != null) {
            return cls;
        }
        return super.resolveClass(objectStreamClass);
    }
}
