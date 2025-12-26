package com.google.gson.internal;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import p000.d91;
import p000.e91;
import p000.x30;

/* loaded from: classes2.dex */
public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {

    /* renamed from: i */
    public static final x30 f15728i = new x30(3);

    /* renamed from: a */
    public final Comparator f15729a;

    /* renamed from: b */
    public final boolean f15730b;

    /* renamed from: c */
    public e91 f15731c;

    /* renamed from: d */
    public int f15732d;

    /* renamed from: e */
    public int f15733e;

    /* renamed from: f */
    public final e91 f15734f;

    /* renamed from: g */
    public d91 f15735g;

    /* renamed from: h */
    public d91 f15736h;

    public LinkedTreeMap() {
        this(f15728i, true);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization is unsupported");
    }

    private Object writeReplace() {
        return new LinkedHashMap(this);
    }

    /* renamed from: a */
    public final e91 m4421a(Object obj, boolean z) {
        int i;
        e91 e91Var;
        Comparable comparable;
        e91 e91Var2;
        e91 e91Var3 = this.f15731c;
        x30 x30Var = f15728i;
        Comparator comparator = this.f15729a;
        if (e91Var3 != null) {
            if (comparator == x30Var) {
                comparable = (Comparable) obj;
            } else {
                comparable = null;
            }
            while (true) {
                Object obj2 = e91Var3.f16722f;
                if (comparable != null) {
                    i = comparable.compareTo(obj2);
                } else {
                    i = comparator.compare(obj, obj2);
                }
                if (i == 0) {
                    return e91Var3;
                }
                if (i < 0) {
                    e91Var2 = e91Var3.f16718b;
                } else {
                    e91Var2 = e91Var3.f16719c;
                }
                if (e91Var2 == null) {
                    break;
                }
                e91Var3 = e91Var2;
            }
        } else {
            i = 0;
        }
        if (!z) {
            return null;
        }
        e91 e91Var4 = this.f15734f;
        if (e91Var3 == null) {
            if (comparator == x30Var && !(obj instanceof Comparable)) {
                throw new ClassCastException(obj.getClass().getName().concat(" is not Comparable"));
            }
            e91Var = new e91(this.f15730b, e91Var3, obj, e91Var4, e91Var4.f16721e);
            this.f15731c = e91Var;
        } else {
            e91Var = new e91(this.f15730b, e91Var3, obj, e91Var4, e91Var4.f16721e);
            if (i < 0) {
                e91Var3.f16718b = e91Var;
            } else {
                e91Var3.f16719c = e91Var;
            }
            m4422c(e91Var3, true);
        }
        this.f15732d++;
        this.f15733e++;
        return e91Var;
    }

    /* renamed from: c */
    public final void m4422c(e91 e91Var, boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        while (e91Var != null) {
            e91 e91Var2 = e91Var.f16718b;
            e91 e91Var3 = e91Var.f16719c;
            int i5 = 0;
            if (e91Var2 != null) {
                i = e91Var2.f16725i;
            } else {
                i = 0;
            }
            if (e91Var3 != null) {
                i2 = e91Var3.f16725i;
            } else {
                i2 = 0;
            }
            int i6 = i - i2;
            if (i6 == -2) {
                e91 e91Var4 = e91Var3.f16718b;
                e91 e91Var5 = e91Var3.f16719c;
                if (e91Var5 != null) {
                    i4 = e91Var5.f16725i;
                } else {
                    i4 = 0;
                }
                if (e91Var4 != null) {
                    i5 = e91Var4.f16725i;
                }
                int i7 = i5 - i4;
                if (i7 != -1 && (i7 != 0 || z)) {
                    m4426h(e91Var3);
                    m4425g(e91Var);
                } else {
                    m4425g(e91Var);
                }
                if (z) {
                    return;
                }
            } else if (i6 == 2) {
                e91 e91Var6 = e91Var2.f16718b;
                e91 e91Var7 = e91Var2.f16719c;
                if (e91Var7 != null) {
                    i3 = e91Var7.f16725i;
                } else {
                    i3 = 0;
                }
                if (e91Var6 != null) {
                    i5 = e91Var6.f16725i;
                }
                int i8 = i5 - i3;
                if (i8 != 1 && (i8 != 0 || z)) {
                    m4425g(e91Var2);
                    m4426h(e91Var);
                } else {
                    m4426h(e91Var);
                }
                if (z) {
                    return;
                }
            } else if (i6 == 0) {
                e91Var.f16725i = i + 1;
                if (z) {
                    return;
                }
            } else {
                e91Var.f16725i = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            e91Var = e91Var.f16717a;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f15731c = null;
        this.f15732d = 0;
        this.f15733e++;
        e91 e91Var = this.f15734f;
        e91Var.f16721e = e91Var;
        e91Var.f16720d = e91Var;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        e91 e91Var = null;
        if (obj != null) {
            try {
                e91Var = m4421a(obj, false);
            } catch (ClassCastException unused) {
            }
        }
        if (e91Var == null) {
            return false;
        }
        return true;
    }

    /* renamed from: e */
    public final void m4423e(e91 e91Var, boolean z) {
        e91 e91Var2;
        e91 e91Var3;
        int i;
        if (z) {
            e91 e91Var4 = e91Var.f16721e;
            e91Var4.f16720d = e91Var.f16720d;
            e91Var.f16720d.f16721e = e91Var4;
        }
        e91 e91Var5 = e91Var.f16718b;
        e91 e91Var6 = e91Var.f16719c;
        e91 e91Var7 = e91Var.f16717a;
        int i2 = 0;
        if (e91Var5 != null && e91Var6 != null) {
            if (e91Var5.f16725i > e91Var6.f16725i) {
                e91 e91Var8 = e91Var5.f16719c;
                while (true) {
                    e91 e91Var9 = e91Var8;
                    e91Var3 = e91Var5;
                    e91Var5 = e91Var9;
                    if (e91Var5 == null) {
                        break;
                    } else {
                        e91Var8 = e91Var5.f16719c;
                    }
                }
            } else {
                e91 e91Var10 = e91Var6.f16718b;
                while (true) {
                    e91Var2 = e91Var6;
                    e91Var6 = e91Var10;
                    if (e91Var6 == null) {
                        break;
                    } else {
                        e91Var10 = e91Var6.f16718b;
                    }
                }
                e91Var3 = e91Var2;
            }
            m4423e(e91Var3, false);
            e91 e91Var11 = e91Var.f16718b;
            if (e91Var11 != null) {
                i = e91Var11.f16725i;
                e91Var3.f16718b = e91Var11;
                e91Var11.f16717a = e91Var3;
                e91Var.f16718b = null;
            } else {
                i = 0;
            }
            e91 e91Var12 = e91Var.f16719c;
            if (e91Var12 != null) {
                i2 = e91Var12.f16725i;
                e91Var3.f16719c = e91Var12;
                e91Var12.f16717a = e91Var3;
                e91Var.f16719c = null;
            }
            e91Var3.f16725i = Math.max(i, i2) + 1;
            m4424f(e91Var, e91Var3);
            return;
        }
        if (e91Var5 != null) {
            m4424f(e91Var, e91Var5);
            e91Var.f16718b = null;
        } else if (e91Var6 != null) {
            m4424f(e91Var, e91Var6);
            e91Var.f16719c = null;
        } else {
            m4424f(e91Var, null);
        }
        m4422c(e91Var7, false);
        this.f15732d--;
        this.f15733e++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        d91 d91Var = this.f15735g;
        if (d91Var == null) {
            d91 d91Var2 = new d91(this, 0);
            this.f15735g = d91Var2;
            return d91Var2;
        }
        return d91Var;
    }

    /* renamed from: f */
    public final void m4424f(e91 e91Var, e91 e91Var2) {
        e91 e91Var3 = e91Var.f16717a;
        e91Var.f16717a = null;
        if (e91Var2 != null) {
            e91Var2.f16717a = e91Var3;
        }
        if (e91Var3 != null) {
            if (e91Var3.f16718b == e91Var) {
                e91Var3.f16718b = e91Var2;
                return;
            } else {
                e91Var3.f16719c = e91Var2;
                return;
            }
        }
        this.f15731c = e91Var2;
    }

    /* renamed from: g */
    public final void m4425g(e91 e91Var) {
        int i;
        int i2;
        e91 e91Var2 = e91Var.f16718b;
        e91 e91Var3 = e91Var.f16719c;
        e91 e91Var4 = e91Var3.f16718b;
        e91 e91Var5 = e91Var3.f16719c;
        e91Var.f16719c = e91Var4;
        if (e91Var4 != null) {
            e91Var4.f16717a = e91Var;
        }
        m4424f(e91Var, e91Var3);
        e91Var3.f16718b = e91Var;
        e91Var.f16717a = e91Var3;
        int i3 = 0;
        if (e91Var2 != null) {
            i = e91Var2.f16725i;
        } else {
            i = 0;
        }
        if (e91Var4 != null) {
            i2 = e91Var4.f16725i;
        } else {
            i2 = 0;
        }
        int max = Math.max(i, i2) + 1;
        e91Var.f16725i = max;
        if (e91Var5 != null) {
            i3 = e91Var5.f16725i;
        }
        e91Var3.f16725i = Math.max(max, i3) + 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000c  */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public V get(Object obj) {
        e91 e91Var;
        if (obj != null) {
            try {
                e91Var = m4421a(obj, false);
            } catch (ClassCastException unused) {
            }
            if (e91Var != null) {
                return null;
            }
            return (V) e91Var.f16724h;
        }
        e91Var = null;
        if (e91Var != null) {
        }
    }

    /* renamed from: h */
    public final void m4426h(e91 e91Var) {
        int i;
        int i2;
        e91 e91Var2 = e91Var.f16718b;
        e91 e91Var3 = e91Var.f16719c;
        e91 e91Var4 = e91Var2.f16718b;
        e91 e91Var5 = e91Var2.f16719c;
        e91Var.f16718b = e91Var5;
        if (e91Var5 != null) {
            e91Var5.f16717a = e91Var;
        }
        m4424f(e91Var, e91Var2);
        e91Var2.f16719c = e91Var;
        e91Var.f16717a = e91Var2;
        int i3 = 0;
        if (e91Var3 != null) {
            i = e91Var3.f16725i;
        } else {
            i = 0;
        }
        if (e91Var5 != null) {
            i2 = e91Var5.f16725i;
        } else {
            i2 = 0;
        }
        int max = Math.max(i, i2) + 1;
        e91Var.f16725i = max;
        if (e91Var4 != null) {
            i3 = e91Var4.f16725i;
        }
        e91Var2.f16725i = Math.max(max, i3) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        d91 d91Var = this.f15736h;
        if (d91Var == null) {
            d91 d91Var2 = new d91(this, 1);
            this.f15736h = d91Var2;
            return d91Var2;
        }
        return d91Var;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        if (k != null) {
            if (v == null && !this.f15730b) {
                throw new NullPointerException("value == null");
            }
            e91 m4421a = m4421a(k, true);
            V v2 = (V) m4421a.f16724h;
            m4421a.f16724h = v;
            return v2;
        }
        throw new NullPointerException("key == null");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0012  */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public V remove(Object obj) {
        e91 e91Var;
        if (obj != null) {
            try {
                e91Var = m4421a(obj, false);
            } catch (ClassCastException unused) {
            }
            if (e91Var != null) {
                m4423e(e91Var, true);
            }
            if (e91Var != null) {
                return null;
            }
            return (V) e91Var.f16724h;
        }
        e91Var = null;
        if (e91Var != null) {
        }
        if (e91Var != null) {
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f15732d;
    }

    public LinkedTreeMap(boolean z) {
        this(f15728i, z);
    }

    public LinkedTreeMap(Comparator<? super K> comparator, boolean z) {
        this.f15732d = 0;
        this.f15733e = 0;
        this.f15729a = comparator == null ? f15728i : comparator;
        this.f15730b = z;
        this.f15734f = new e91(z);
    }
}
