package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import javax.annotation.CheckForNull;
import p000.AbstractC1726qj;

@GwtIncompatible
/* loaded from: classes.dex */
public enum StandardSystemProperty {
    JAVA_VERSION("java.version"),
    JAVA_VENDOR("java.vendor"),
    JAVA_VENDOR_URL("java.vendor.url"),
    JAVA_HOME("java.home"),
    JAVA_VM_SPECIFICATION_VERSION("java.vm.specification.version"),
    JAVA_VM_SPECIFICATION_VENDOR("java.vm.specification.vendor"),
    JAVA_VM_SPECIFICATION_NAME("java.vm.specification.name"),
    JAVA_VM_VERSION("java.vm.version"),
    JAVA_VM_VENDOR("java.vm.vendor"),
    JAVA_VM_NAME("java.vm.name"),
    JAVA_SPECIFICATION_VERSION("java.specification.version"),
    JAVA_SPECIFICATION_VENDOR("java.specification.vendor"),
    JAVA_SPECIFICATION_NAME("java.specification.name"),
    JAVA_CLASS_VERSION("java.class.version"),
    JAVA_CLASS_PATH("java.class.path"),
    JAVA_LIBRARY_PATH("java.library.path"),
    JAVA_IO_TMPDIR("java.io.tmpdir"),
    JAVA_COMPILER("java.compiler"),
    JAVA_EXT_DIRS("java.ext.dirs"),
    OS_NAME("os.name"),
    OS_ARCH("os.arch"),
    OS_VERSION("os.version"),
    FILE_SEPARATOR("file.separator"),
    PATH_SEPARATOR("path.separator"),
    LINE_SEPARATOR("line.separator"),
    USER_NAME("user.name"),
    USER_HOME("user.home"),
    USER_DIR("user.dir");


    /* renamed from: a */
    public final String f14495a;

    StandardSystemProperty(String str) {
        this.f14495a = str;
    }

    public String key() {
        return this.f14495a;
    }

    @Override // java.lang.Enum
    public String toString() {
        String key = key();
        String value = value();
        return AbstractC1726qj.m7059o(key, "=", value, AbstractC1726qj.m7052h(AbstractC1726qj.m7052h(1, key), value));
    }

    @CheckForNull
    public String value() {
        return System.getProperty(this.f14495a);
    }
}
