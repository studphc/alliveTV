package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import p000.ex0;

/* loaded from: classes.dex */
public final class GlideException extends Exception {

    /* renamed from: g */
    public static final StackTraceElement[] f8680g = new StackTraceElement[0];
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    public final List f8681a;

    /* renamed from: b */
    public Key f8682b;

    /* renamed from: c */
    public DataSource f8683c;

    /* renamed from: d */
    public Class f8684d;

    /* renamed from: e */
    public final String f8685e;

    /* renamed from: f */
    public Exception f8686f;

    public GlideException(String str) {
        this(str, (List<Throwable>) Collections.emptyList());
    }

    /* renamed from: a */
    public static void m2317a(Throwable th, ArrayList arrayList) {
        if (th instanceof GlideException) {
            Iterator<Throwable> it = ((GlideException) th).getCauses().iterator();
            while (it.hasNext()) {
                m2317a(it.next(), arrayList);
            }
            return;
        }
        arrayList.add(th);
    }

    /* renamed from: b */
    public static void m2318b(List list, ex0 ex0Var) {
        try {
            m2319c(list, ex0Var);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: c */
    public static void m2319c(List list, ex0 ex0Var) {
        int size = list.size();
        int i = 0;
        while (i < size) {
            ex0Var.append("Cause (");
            int i2 = i + 1;
            ex0Var.append(String.valueOf(i2));
            ex0Var.append(" of ");
            ex0Var.append(String.valueOf(size));
            ex0Var.append("): ");
            Throwable th = (Throwable) list.get(i);
            if (th instanceof GlideException) {
                GlideException glideException = (GlideException) th;
                glideException.getClass();
                m2320d(glideException, ex0Var);
                m2318b(glideException.getCauses(), new ex0(ex0Var));
            } else {
                m2320d(th, ex0Var);
            }
            i = i2;
        }
    }

    /* renamed from: d */
    public static void m2320d(Throwable th, Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append('\n');
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }

    public List<Throwable> getCauses() {
        return this.f8681a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder(71);
        sb.append(this.f8685e);
        String str3 = "";
        if (this.f8684d == null) {
            str = "";
        } else {
            str = ", " + this.f8684d;
        }
        sb.append(str);
        if (this.f8683c == null) {
            str2 = "";
        } else {
            str2 = ", " + this.f8683c;
        }
        sb.append(str2);
        if (this.f8682b != null) {
            str3 = ", " + this.f8682b;
        }
        sb.append(str3);
        List<Throwable> rootCauses = getRootCauses();
        if (rootCauses.isEmpty()) {
            return sb.toString();
        }
        if (rootCauses.size() == 1) {
            sb.append("\nThere was 1 root cause:");
        } else {
            sb.append("\nThere were ");
            sb.append(rootCauses.size());
            sb.append(" root causes:");
        }
        for (Throwable th : rootCauses) {
            sb.append('\n');
            sb.append(th.getClass().getName());
            sb.append('(');
            sb.append(th.getMessage());
            sb.append(')');
        }
        sb.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb.toString();
    }

    @Nullable
    public Exception getOrigin() {
        return this.f8686f;
    }

    public List<Throwable> getRootCauses() {
        ArrayList arrayList = new ArrayList();
        m2317a(this, arrayList);
        return arrayList;
    }

    public void logRootCauses(String str) {
        List<Throwable> rootCauses = getRootCauses();
        int size = rootCauses.size();
        int i = 0;
        while (i < size) {
            StringBuilder sb = new StringBuilder("Root cause (");
            int i2 = i + 1;
            sb.append(i2);
            sb.append(" of ");
            sb.append(size);
            sb.append(")");
            Log.i(str, sb.toString(), rootCauses.get(i));
            i = i2;
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void setOrigin(@Nullable Exception exc) {
        this.f8686f = exc;
    }

    public GlideException(String str, Throwable th) {
        this(str, (List<Throwable>) Collections.singletonList(th));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        m2320d(this, printStream);
        m2318b(getCauses(), new ex0(printStream));
    }

    public GlideException(String str, List<Throwable> list) {
        this.f8685e = str;
        setStackTrace(f8680g);
        this.f8681a = list;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        m2320d(this, printWriter);
        m2318b(getCauses(), new ex0(printWriter));
    }
}
