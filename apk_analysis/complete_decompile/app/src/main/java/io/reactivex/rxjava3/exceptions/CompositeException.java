package io.reactivex.rxjava3.exceptions;

import io.reactivex.rxjava3.annotations.NonNull;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import p000.C1098cu;
import p000.o63;

/* loaded from: classes2.dex */
public final class CompositeException extends RuntimeException {
    private static final long serialVersionUID = 3026362227162912146L;

    /* renamed from: a */
    public final List f18509a;

    /* renamed from: b */
    public final String f18510b;

    /* renamed from: c */
    public Throwable f18511c;

    public CompositeException(@NonNull Throwable... thArr) {
        this(thArr == null ? Collections.singletonList(new NullPointerException("exceptions was null")) : Arrays.asList(thArr));
    }

    /* renamed from: a */
    public static void m5269a(o63 o63Var, Throwable th, String str) {
        o63Var.mo4488b(str).mo4488b(th).mo4488b('\n');
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            o63Var.mo4488b("\t\tat ").mo4488b(stackTraceElement).mo4488b('\n');
        }
        if (th.getCause() != null) {
            o63Var.mo4488b("\tCaused by: ");
            m5269a(o63Var, th.getCause(), "");
        }
    }

    /* renamed from: b */
    public final void m5270b(o63 o63Var) {
        o63Var.mo4488b(this).mo4488b("\n");
        for (StackTraceElement stackTraceElement : getStackTrace()) {
            o63Var.mo4488b("\tat ").mo4488b(stackTraceElement).mo4488b("\n");
        }
        int i = 1;
        for (Throwable th : this.f18509a) {
            o63Var.mo4488b("  ComposedException ").mo4488b(Integer.valueOf(i)).mo4488b(" :\n");
            m5269a(o63Var, th, "\t");
            i++;
        }
        o63Var.mo4488b("\n");
    }

    @Override // java.lang.Throwable
    @NonNull
    public synchronized Throwable getCause() {
        int i;
        try {
            if (this.f18511c == null) {
                String property = System.getProperty("line.separator");
                if (this.f18509a.size() > 1) {
                    IdentityHashMap identityHashMap = new IdentityHashMap();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Multiple exceptions (");
                    sb.append(this.f18509a.size());
                    sb.append(")");
                    sb.append(property);
                    for (Throwable th : this.f18509a) {
                        int i2 = 0;
                        while (true) {
                            if (th != null) {
                                for (int i3 = 0; i3 < i2; i3++) {
                                    sb.append("  ");
                                }
                                sb.append("|-- ");
                                sb.append(th.getClass().getCanonicalName());
                                sb.append(": ");
                                String message = th.getMessage();
                                if (message != null && message.contains(property)) {
                                    sb.append(property);
                                    for (String str : message.split(property)) {
                                        for (int i4 = 0; i4 < i2 + 2; i4++) {
                                            sb.append("  ");
                                        }
                                        sb.append(str);
                                        sb.append(property);
                                    }
                                } else {
                                    sb.append(message);
                                    sb.append(property);
                                }
                                int i5 = 0;
                                while (true) {
                                    i = i2 + 2;
                                    if (i5 >= i) {
                                        break;
                                    }
                                    sb.append("  ");
                                    i5++;
                                }
                                StackTraceElement[] stackTrace = th.getStackTrace();
                                if (stackTrace.length > 0) {
                                    sb.append("at ");
                                    sb.append(stackTrace[0]);
                                    sb.append(property);
                                }
                                if (!identityHashMap.containsKey(th)) {
                                    identityHashMap.put(th, Boolean.TRUE);
                                    th = th.getCause();
                                    i2++;
                                } else {
                                    Throwable cause = th.getCause();
                                    if (cause != null) {
                                        for (int i6 = 0; i6 < i; i6++) {
                                            sb.append("  ");
                                        }
                                        sb.append("|-- ");
                                        sb.append("(cause not expanded again) ");
                                        sb.append(cause.getClass().getCanonicalName());
                                        sb.append(": ");
                                        sb.append(cause.getMessage());
                                        sb.append(property);
                                    }
                                }
                            }
                        }
                    }
                    this.f18511c = new RuntimeException(sb.toString().trim());
                } else {
                    this.f18511c = (Throwable) this.f18509a.get(0);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f18511c;
    }

    @NonNull
    public List<Throwable> getExceptions() {
        return this.f18509a;
    }

    @Override // java.lang.Throwable
    @NonNull
    public String getMessage() {
        return this.f18510b;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public int size() {
        return this.f18509a.size();
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        m5270b(new C1098cu(0, printStream));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        m5270b(new C1098cu(1, printWriter));
    }

    public CompositeException(@NonNull Iterable<? extends Throwable> iterable) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (iterable != null) {
            for (Throwable th : iterable) {
                if (th instanceof CompositeException) {
                    linkedHashSet.addAll(((CompositeException) th).getExceptions());
                } else if (th != null) {
                    linkedHashSet.add(th);
                } else {
                    linkedHashSet.add(new NullPointerException("Throwable was null!"));
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException("errors was null"));
        }
        if (!linkedHashSet.isEmpty()) {
            List unmodifiableList = Collections.unmodifiableList(new ArrayList(linkedHashSet));
            this.f18509a = unmodifiableList;
            this.f18510b = unmodifiableList.size() + " exceptions occurred. ";
            return;
        }
        throw new IllegalArgumentException("errors is empty");
    }
}
