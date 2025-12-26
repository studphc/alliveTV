package kotlin.jvm.internal;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import kotlin.SinceKotlin;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.reflect.KCallable;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KParameter;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import p000.C1727qk;

/* loaded from: classes2.dex */
public abstract class CallableReference implements KCallable, Serializable {

    @SinceKotlin(version = "1.1")
    public static final Object NO_RECEIVER = C1727qk.f25630a;

    /* renamed from: a */
    public transient KCallable f21161a;

    /* renamed from: b */
    public final Class f21162b;

    /* renamed from: c */
    public final String f21163c;

    /* renamed from: d */
    public final String f21164d;

    /* renamed from: e */
    public final boolean f21165e;

    @SinceKotlin(version = "1.1")
    protected final Object receiver;

    public CallableReference() {
        this(NO_RECEIVER);
    }

    @Override // kotlin.reflect.KCallable
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // kotlin.reflect.KCallable
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    @SinceKotlin(version = "1.1")
    public KCallable compute() {
        KCallable kCallable = this.f21161a;
        if (kCallable == null) {
            KCallable computeReflected = computeReflected();
            this.f21161a = computeReflected;
            return computeReflected;
        }
        return kCallable;
    }

    public abstract KCallable computeReflected();

    @Override // kotlin.reflect.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    @SinceKotlin(version = "1.1")
    public Object getBoundReceiver() {
        return this.receiver;
    }

    @Override // kotlin.reflect.KCallable
    public String getName() {
        return this.f21163c;
    }

    public KDeclarationContainer getOwner() {
        Class cls = this.f21162b;
        if (cls == null) {
            return null;
        }
        if (this.f21165e) {
            return Reflection.getOrCreateKotlinPackage(cls);
        }
        return Reflection.getOrCreateKotlinClass(cls);
    }

    @Override // kotlin.reflect.KCallable
    public List<KParameter> getParameters() {
        return getReflected().getParameters();
    }

    @SinceKotlin(version = "1.1")
    public KCallable getReflected() {
        KCallable compute = compute();
        if (compute != this) {
            return compute;
        }
        throw new KotlinReflectionNotSupportedError();
    }

    @Override // kotlin.reflect.KCallable
    public KType getReturnType() {
        return getReflected().getReturnType();
    }

    public String getSignature() {
        return this.f21164d;
    }

    @Override // kotlin.reflect.KCallable
    @SinceKotlin(version = "1.1")
    public List<KTypeParameter> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // kotlin.reflect.KCallable
    @SinceKotlin(version = "1.1")
    public KVisibility getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // kotlin.reflect.KCallable
    @SinceKotlin(version = "1.1")
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // kotlin.reflect.KCallable
    @SinceKotlin(version = "1.1")
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // kotlin.reflect.KCallable
    @SinceKotlin(version = "1.1")
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override // kotlin.reflect.KCallable
    @SinceKotlin(version = "1.3")
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    @SinceKotlin(version = "1.1")
    public CallableReference(Object obj) {
        this(obj, null, null, null, false);
    }

    @SinceKotlin(version = "1.4")
    public CallableReference(Object obj, Class cls, String str, String str2, boolean z) {
        this.receiver = obj;
        this.f21162b = cls;
        this.f21163c = str;
        this.f21164d = str2;
        this.f21165e = z;
    }
}
