package p000;

import androidx.core.text.TextDirectionHeuristicCompat;
import com.bumptech.glide.util.Util;
import com.google.common.collect.Sets;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.nio.CharBuffer;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

/* loaded from: classes.dex */
public abstract class ge3 implements TextDirectionHeuristicCompat {

    /* renamed from: a */
    public final Object f17677a;

    public /* synthetic */ ge3(Object obj) {
        this.f17677a = obj;
    }

    /* renamed from: a */
    public abstract boolean mo4941a();

    /* renamed from: b */
    public void m4942b(n62 n62Var) {
        Queue queue = (Queue) this.f17677a;
        if (queue.size() < 20) {
            queue.offer(n62Var);
        }
    }

    /* renamed from: c */
    public void m4943c(Type... typeArr) {
        for (Type type : typeArr) {
            if (type != null) {
                HashSet hashSet = (HashSet) this.f17677a;
                if (hashSet.add(type)) {
                    try {
                        if (type instanceof TypeVariable) {
                            mo4948h((TypeVariable) type);
                        } else if (type instanceof WildcardType) {
                            mo4949i((WildcardType) type);
                        } else if (type instanceof ParameterizedType) {
                            mo4947g((ParameterizedType) type);
                        } else if (type instanceof Class) {
                            mo4944d((Class) type);
                        } else if (type instanceof GenericArrayType) {
                            mo4945e((GenericArrayType) type);
                        } else {
                            String valueOf = String.valueOf(type);
                            StringBuilder sb = new StringBuilder(valueOf.length() + 14);
                            sb.append("Unknown type: ");
                            sb.append(valueOf);
                            throw new AssertionError(sb.toString());
                        }
                    } catch (Throwable th) {
                        hashSet.remove(type);
                        throw th;
                    }
                } else {
                    continue;
                }
            }
        }
    }

    /* renamed from: f */
    public abstract Object mo4946f(ArrayDeque arrayDeque);

    /* renamed from: h */
    public abstract void mo4948h(TypeVariable typeVariable);

    /* renamed from: i */
    public abstract void mo4949i(WildcardType wildcardType);

    @Override // androidx.core.text.TextDirectionHeuristicCompat
    public boolean isRtl(char[] cArr, int i, int i2) {
        return isRtl(CharBuffer.wrap(cArr), i, i2);
    }

    /* renamed from: j */
    public abstract double mo4693j(Object obj, long j);

    /* renamed from: k */
    public abstract float mo4694k(Object obj, long j);

    /* renamed from: l */
    public abstract void mo4695l(Object obj, long j, boolean z);

    /* renamed from: m */
    public abstract void mo4696m(Object obj, long j, byte b);

    /* renamed from: n */
    public abstract void mo4697n(Object obj, long j, double d);

    /* renamed from: o */
    public abstract void mo4698o(Object obj, long j, float f);

    /* renamed from: p */
    public abstract boolean mo4699p(Object obj, long j);

    public ge3(int i) {
        switch (i) {
            case 6:
                this.f17677a = Sets.newHashSet();
                return;
            default:
                this.f17677a = Util.createQueue(20);
                return;
        }
    }

    @Override // androidx.core.text.TextDirectionHeuristicCompat
    public boolean isRtl(CharSequence charSequence, int i, int i2) {
        if (charSequence != null && i >= 0 && i2 >= 0 && charSequence.length() - i2 >= i) {
            ss2 ss2Var = (ss2) this.f17677a;
            if (ss2Var == null) {
                return mo4941a();
            }
            int mo4628j = ss2Var.mo4628j(charSequence, i, i2);
            if (mo4628j == 0) {
                return true;
            }
            if (mo4628j != 1) {
                return mo4941a();
            }
            return false;
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: d */
    public void mo4944d(Class cls) {
    }

    /* renamed from: e */
    public void mo4945e(GenericArrayType genericArrayType) {
    }

    /* renamed from: g */
    public void mo4947g(ParameterizedType parameterizedType) {
    }
}
