package p000;

import com.google.common.base.Joiner;
import com.google.common.reflect.Invokable;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class f51 extends Invokable {

    /* renamed from: c */
    public final /* synthetic */ int f17127c = 0;

    /* renamed from: d */
    public final AccessibleObject f17128d;

    public f51(Method method) {
        super(method);
        this.f17128d = method;
    }

    @Override // com.google.common.reflect.Invokable
    /* renamed from: a */
    public Type[] mo4280a() {
        switch (this.f17127c) {
            case 0:
                return ((Constructor) this.f17128d).getGenericExceptionTypes();
            default:
                return ((Method) this.f17128d).getGenericExceptionTypes();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    @Override // com.google.common.reflect.Invokable
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Type[] mo4281b() {
        boolean z;
        switch (this.f17127c) {
            case 0:
                Constructor constructor = (Constructor) this.f17128d;
                Type[] genericParameterTypes = constructor.getGenericParameterTypes();
                if (genericParameterTypes.length > 0) {
                    Class declaringClass = constructor.getDeclaringClass();
                    if (declaringClass.getEnclosingConstructor() == null) {
                        Method enclosingMethod = declaringClass.getEnclosingMethod();
                        if (enclosingMethod != null) {
                            z = !Modifier.isStatic(enclosingMethod.getModifiers());
                        } else if (declaringClass.getEnclosingClass() == null || Modifier.isStatic(declaringClass.getModifiers())) {
                            z = false;
                        }
                        if (!z) {
                            Class<?>[] parameterTypes = constructor.getParameterTypes();
                            if (genericParameterTypes.length == parameterTypes.length && parameterTypes[0] == getDeclaringClass().getEnclosingClass()) {
                                return (Type[]) Arrays.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length);
                            }
                            return genericParameterTypes;
                        }
                        return genericParameterTypes;
                    }
                    z = true;
                    if (!z) {
                    }
                } else {
                    return genericParameterTypes;
                }
                break;
            default:
                return ((Method) this.f17128d).getGenericParameterTypes();
        }
    }

    @Override // com.google.common.reflect.Invokable
    /* renamed from: c */
    public Type mo4282c() {
        switch (this.f17127c) {
            case 0:
                Class declaringClass = getDeclaringClass();
                TypeVariable[] typeParameters = declaringClass.getTypeParameters();
                if (typeParameters.length > 0) {
                    Joiner joiner = mz2.f23181a;
                    return new iz2(zy2.f29573a.mo8083a(declaringClass), declaringClass, typeParameters);
                }
                return declaringClass;
            default:
                return ((Method) this.f17128d).getGenericReturnType();
        }
    }

    @Override // com.google.common.reflect.Invokable
    /* renamed from: d */
    public final Annotation[][] mo4283d() {
        switch (this.f17127c) {
            case 0:
                return ((Constructor) this.f17128d).getParameterAnnotations();
            default:
                return ((Method) this.f17128d).getParameterAnnotations();
        }
    }

    @Override // com.google.common.reflect.Invokable
    /* renamed from: e */
    public final Object mo4284e(Object obj, Object[] objArr) {
        switch (this.f17127c) {
            case 0:
                Constructor constructor = (Constructor) this.f17128d;
                try {
                    return constructor.newInstance(objArr);
                } catch (InstantiationException e) {
                    String valueOf = String.valueOf(constructor);
                    throw new RuntimeException(AbstractC1726qj.m7054j(valueOf.length() + 8, valueOf, " failed."), e);
                }
            default:
                return ((Method) this.f17128d).invoke(obj, objArr);
        }
    }

    @Override // com.google.common.reflect.Invokable
    public final TypeVariable[] getTypeParameters() {
        switch (this.f17127c) {
            case 0:
                TypeVariable[] typeParameters = getDeclaringClass().getTypeParameters();
                TypeVariable[] typeParameters2 = ((Constructor) this.f17128d).getTypeParameters();
                TypeVariable[] typeVariableArr = new TypeVariable[typeParameters.length + typeParameters2.length];
                System.arraycopy(typeParameters, 0, typeVariableArr, 0, typeParameters.length);
                System.arraycopy(typeParameters2, 0, typeVariableArr, typeParameters.length, typeParameters2.length);
                return typeVariableArr;
            default:
                return ((Method) this.f17128d).getTypeParameters();
        }
    }

    @Override // com.google.common.reflect.Invokable
    public final boolean isOverridable() {
        switch (this.f17127c) {
            case 0:
                return false;
            default:
                if (!isFinal() && !isPrivate() && !isStatic() && !Modifier.isFinal(getDeclaringClass().getModifiers())) {
                    return true;
                }
                return false;
        }
    }

    @Override // com.google.common.reflect.Invokable
    public final boolean isVarArgs() {
        switch (this.f17127c) {
            case 0:
                return ((Constructor) this.f17128d).isVarArgs();
            default:
                return ((Method) this.f17128d).isVarArgs();
        }
    }

    public f51(Constructor constructor) {
        super(constructor);
        this.f17128d = constructor;
    }
}
