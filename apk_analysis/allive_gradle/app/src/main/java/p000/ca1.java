package p000;

import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.collect.ForwardingList;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public class ca1 extends AbstractList {

    /* renamed from: a */
    public final /* synthetic */ int f8305a = 0;

    /* renamed from: b */
    public final Object f8306b;

    public ca1(Throwable th) {
        this.f8306b = th;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, Object obj) {
        switch (this.f8305a) {
            case 0:
                ((List) this.f8306b).add(i, obj);
                return;
            default:
                super.add(i, obj);
                return;
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection collection) {
        switch (this.f8305a) {
            case 0:
                return ((List) this.f8306b).addAll(i, collection);
            default:
                return super.addAll(i, collection);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        switch (this.f8305a) {
            case 0:
                return ((List) this.f8306b).contains(obj);
            default:
                return super.contains(obj);
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        Object obj = this.f8306b;
        switch (this.f8305a) {
            case 0:
                return ((List) obj).get(i);
            case 1:
                CharSequence charSequence = (CharSequence) obj;
                Preconditions.checkElementIndex(i, charSequence.length());
                return Character.valueOf(charSequence.charAt(i));
            default:
                Method method = Throwables.f14501b;
                Objects.requireNonNull(method);
                Object obj2 = Throwables.f14500a;
                Objects.requireNonNull(obj2);
                try {
                    return (StackTraceElement) method.invoke(obj2, (Throwable) obj, Integer.valueOf(i));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e2) {
                    throw Throwables.propagate(e2.getCause());
                }
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public Object remove(int i) {
        switch (this.f8305a) {
            case 0:
                return ((List) this.f8306b).remove(i);
            default:
                return super.remove(i);
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i, Object obj) {
        switch (this.f8305a) {
            case 0:
                return ((List) this.f8306b).set(i, obj);
            default:
                return super.set(i, obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        Object obj = this.f8306b;
        switch (this.f8305a) {
            case 0:
                return ((List) obj).size();
            case 1:
                return ((CharSequence) obj).length();
            default:
                Method method = Throwables.f14502c;
                Objects.requireNonNull(method);
                Object obj2 = Throwables.f14500a;
                Objects.requireNonNull(obj2);
                try {
                    return ((Integer) method.invoke(obj2, (Throwable) obj)).intValue();
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e2) {
                    throw Throwables.propagate(e2.getCause());
                }
        }
    }

    public ca1(CharSequence charSequence) {
        this.f8306b = charSequence;
    }

    public ca1(ForwardingList forwardingList) {
        this.f8306b = (List) Preconditions.checkNotNull(forwardingList);
    }
}
