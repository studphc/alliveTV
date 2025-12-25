package p000;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class pr2 implements Serializable {

    @GwtIncompatible
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Object f25272a;

    /* renamed from: b */
    public final Object f25273b;

    public pr2(Object obj, Object obj2) {
        this.f25272a = Preconditions.checkNotNull(obj);
        this.f25273b = obj2 == null ? this : obj2;
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) {
        synchronized (this.f25273b) {
            objectOutputStream.defaultWriteObject();
        }
    }

    public final String toString() {
        String obj;
        synchronized (this.f25273b) {
            obj = this.f25272a.toString();
        }
        return obj;
    }
}
