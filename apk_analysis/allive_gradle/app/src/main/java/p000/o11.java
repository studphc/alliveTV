package p000;

import java.io.Serializable;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.security.PrivilegedAction;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class o11 implements PrivilegedAction {

    /* renamed from: a */
    public final /* synthetic */ int f23564a;

    /* renamed from: b */
    public final /* synthetic */ Serializable f23565b;

    public /* synthetic */ o11(Serializable serializable, int i) {
        this.f23564a = i;
        this.f23565b = serializable;
    }

    @Override // java.security.PrivilegedAction
    public final Object run() {
        switch (this.f23564a) {
            case 0:
                return System.clearProperty((String) this.f23565b);
            default:
                Field[] declaredFields = ((Class) this.f23565b).getDeclaredFields();
                ArrayList arrayList = new ArrayList(declaredFields.length);
                for (Field field : declaredFields) {
                    if (field.isEnumConstant()) {
                        arrayList.add(field);
                    }
                }
                Field[] fieldArr = (Field[]) arrayList.toArray(new Field[0]);
                AccessibleObject.setAccessible(fieldArr, true);
                return fieldArr;
        }
    }
}
