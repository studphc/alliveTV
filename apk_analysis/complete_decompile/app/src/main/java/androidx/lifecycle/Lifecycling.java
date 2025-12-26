package androidx.lifecycle;

import androidx.annotation.RestrictTo;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p000.AbstractC1167eq;
import p000.AbstractC1726qj;
import p000.ro2;

@Metadata(m5568d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, m5569d2 = {"Landroidx/lifecycle/Lifecycling;", "", "object", "Landroidx/lifecycle/LifecycleEventObserver;", "lifecycleEventObserver", "(Ljava/lang/Object;)Landroidx/lifecycle/LifecycleEventObserver;", "", "className", "getAdapterName", "(Ljava/lang/String;)Ljava/lang/String;", "lifecycle-common"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class Lifecycling {

    @NotNull
    public static final Lifecycling INSTANCE = new Object();

    /* renamed from: a */
    public static final HashMap f6502a = new HashMap();

    /* renamed from: b */
    public static final HashMap f6503b = new HashMap();

    /* renamed from: a */
    public static GeneratedAdapter m1526a(Constructor constructor, Object obj) {
        try {
            Object newInstance = constructor.newInstance(obj);
            Intrinsics.checkNotNullExpressionValue(newInstance, "{\n            constructo…tance(`object`)\n        }");
            return (GeneratedAdapter) newInstance;
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    public static int m1527b(Class cls) {
        Constructor constructor;
        boolean z;
        boolean z2;
        boolean z3;
        String fullPackage;
        int i = 1;
        HashMap hashMap = f6502a;
        Integer num = (Integer) hashMap.get(cls);
        if (num != null) {
            return num.intValue();
        }
        if (cls.getCanonicalName() != null) {
            ArrayList arrayList = null;
            try {
                Package r4 = cls.getPackage();
                String name = cls.getCanonicalName();
                if (r4 != null) {
                    fullPackage = r4.getName();
                } else {
                    fullPackage = "";
                }
                Intrinsics.checkNotNullExpressionValue(fullPackage, "fullPackage");
                if (fullPackage.length() != 0) {
                    Intrinsics.checkNotNullExpressionValue(name, "name");
                    name = name.substring(fullPackage.length() + 1);
                    Intrinsics.checkNotNullExpressionValue(name, "this as java.lang.String).substring(startIndex)");
                }
                Intrinsics.checkNotNullExpressionValue(name, "if (fullPackage.isEmpty(…g(fullPackage.length + 1)");
                String adapterName = getAdapterName(name);
                if (fullPackage.length() != 0) {
                    adapterName = fullPackage + '.' + adapterName;
                }
                Class<?> cls2 = Class.forName(adapterName);
                Intrinsics.checkNotNull(cls2, "null cannot be cast to non-null type java.lang.Class<out androidx.lifecycle.GeneratedAdapter>");
                constructor = cls2.getDeclaredConstructor(cls);
                if (!constructor.isAccessible()) {
                    constructor.setAccessible(true);
                }
            } catch (ClassNotFoundException unused) {
                constructor = null;
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
            HashMap hashMap2 = f6503b;
            if (constructor != null) {
                hashMap2.put(cls, AbstractC1167eq.listOf(constructor));
            } else {
                C0417c c0417c = C0417c.f6583c;
                HashMap hashMap3 = c0417c.f6585b;
                Boolean bool = (Boolean) hashMap3.get(cls);
                if (bool != null) {
                    z = bool.booleanValue();
                } else {
                    try {
                        Method[] declaredMethods = cls.getDeclaredMethods();
                        int length = declaredMethods.length;
                        int i2 = 0;
                        while (true) {
                            if (i2 < length) {
                                if (((OnLifecycleEvent) declaredMethods[i2].getAnnotation(OnLifecycleEvent.class)) != null) {
                                    c0417c.m1542a(cls, declaredMethods);
                                    z = true;
                                    break;
                                }
                                i2++;
                            } else {
                                hashMap3.put(cls, Boolean.FALSE);
                                z = false;
                                break;
                            }
                        }
                    } catch (NoClassDefFoundError e2) {
                        throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e2);
                    }
                }
                if (!z) {
                    Class superclass = cls.getSuperclass();
                    if (superclass != null && LifecycleObserver.class.isAssignableFrom(superclass)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        Intrinsics.checkNotNullExpressionValue(superclass, "superclass");
                        if (m1527b(superclass) != 1) {
                            Object obj = hashMap2.get(superclass);
                            Intrinsics.checkNotNull(obj);
                            arrayList = new ArrayList((Collection) obj);
                        }
                    }
                    Class<?>[] interfaces = cls.getInterfaces();
                    Intrinsics.checkNotNullExpressionValue(interfaces, "klass.interfaces");
                    int length2 = interfaces.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 < length2) {
                            Class<?> intrface = interfaces[i3];
                            if (intrface != null && LifecycleObserver.class.isAssignableFrom(intrface)) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (z3) {
                                Intrinsics.checkNotNullExpressionValue(intrface, "intrface");
                                if (m1527b(intrface) == 1) {
                                    break;
                                }
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                Object obj2 = hashMap2.get(intrface);
                                Intrinsics.checkNotNull(obj2);
                                arrayList.addAll((Collection) obj2);
                            }
                            i3++;
                        } else if (arrayList != null) {
                            hashMap2.put(cls, arrayList);
                        }
                    }
                }
            }
            i = 2;
        }
        hashMap.put(cls, Integer.valueOf(i));
        return i;
    }

    @JvmStatic
    @NotNull
    public static final String getAdapterName(@NotNull String className) {
        Intrinsics.checkNotNullParameter(className, "className");
        return AbstractC1726qj.m7061q(new StringBuilder(), ro2.replace$default(className, ".", "_", false, 4, (Object) null), "_LifecycleAdapter");
    }

    @JvmStatic
    @NotNull
    public static final LifecycleEventObserver lifecycleEventObserver(@NotNull Object object) {
        Intrinsics.checkNotNullParameter(object, "object");
        boolean z = object instanceof LifecycleEventObserver;
        boolean z2 = object instanceof DefaultLifecycleObserver;
        if (z && z2) {
            return new DefaultLifecycleObserverAdapter((DefaultLifecycleObserver) object, (LifecycleEventObserver) object);
        }
        if (z2) {
            return new DefaultLifecycleObserverAdapter((DefaultLifecycleObserver) object, null);
        }
        if (z) {
            return (LifecycleEventObserver) object;
        }
        Class<?> cls = object.getClass();
        INSTANCE.getClass();
        if (m1527b(cls) == 2) {
            Object obj = f6503b.get(cls);
            Intrinsics.checkNotNull(obj);
            List list = (List) obj;
            if (list.size() == 1) {
                return new SingleGeneratedAdapterObserver(m1526a((Constructor) list.get(0), object));
            }
            int size = list.size();
            GeneratedAdapter[] generatedAdapterArr = new GeneratedAdapter[size];
            for (int i = 0; i < size; i++) {
                Lifecycling lifecycling = INSTANCE;
                Constructor constructor = (Constructor) list.get(i);
                lifecycling.getClass();
                generatedAdapterArr[i] = m1526a(constructor, object);
            }
            return new CompositeGeneratedAdaptersObserver(generatedAdapterArr);
        }
        return new ReflectiveGenericLifecycleObserver(object);
    }
}
