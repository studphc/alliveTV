package com.google.common.collect;

import com.google.common.collect.Multiset;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import p000.AbstractC1143e2;
import p000.AbstractC1930w1;
import p000.b01;

/* renamed from: com.google.common.collect.q2 */
/* loaded from: classes.dex */
public abstract class AbstractC0924q2 {
    /* renamed from: a */
    public static b01 m4158a(Class cls, String str) {
        try {
            return new b01(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: b */
    public static void m4159b(Map map, ObjectInputStream objectInputStream, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            map.put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    /* renamed from: c */
    public static void m4160c(AbstractC1930w1 abstractC1930w1, ObjectInputStream objectInputStream, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            Collection collection = abstractC1930w1.get(objectInputStream.readObject());
            int readInt = objectInputStream.readInt();
            for (int i3 = 0; i3 < readInt; i3++) {
                collection.add(objectInputStream.readObject());
            }
        }
    }

    /* renamed from: d */
    public static void m4161d(AbstractC0856d abstractC0856d, ObjectInputStream objectInputStream, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            abstractC0856d.add(objectInputStream.readObject(), objectInputStream.readInt());
        }
    }

    /* renamed from: e */
    public static void m4162e(Map map, ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(map.size());
        for (Map.Entry entry : map.entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    /* renamed from: f */
    public static void m4163f(AbstractC1143e2 abstractC1143e2, ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(abstractC1143e2.asMap().size());
        for (Map.Entry entry : abstractC1143e2.asMap().entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeInt(((Collection) entry.getValue()).size());
            Iterator it = ((Collection) entry.getValue()).iterator();
            while (it.hasNext()) {
                objectOutputStream.writeObject(it.next());
            }
        }
    }

    /* renamed from: g */
    public static void m4164g(AbstractC0856d abstractC0856d, ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(abstractC0856d.entrySet().size());
        for (Multiset.Entry entry : abstractC0856d.entrySet()) {
            objectOutputStream.writeObject(entry.getElement());
            objectOutputStream.writeInt(entry.getCount());
        }
    }
}
