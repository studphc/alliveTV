package androidx.constraintlayout.core.parser;

import androidx.core.os.EnvironmentCompat;
import p000.ye0;

/* loaded from: classes.dex */
public class CLParsingException extends Exception {

    /* renamed from: a */
    public final String f2285a;

    /* renamed from: b */
    public final int f2286b;

    /* renamed from: c */
    public final String f2287c;

    public CLParsingException(String str, CLElement cLElement) {
        super(str);
        this.f2285a = str;
        if (cLElement != null) {
            this.f2287c = cLElement.getStrClass();
            this.f2286b = cLElement.getLine();
        } else {
            this.f2287c = EnvironmentCompat.MEDIA_UNKNOWN;
            this.f2286b = 0;
        }
    }

    public String reason() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2285a);
        sb.append(" (");
        sb.append(this.f2287c);
        sb.append(" at line ");
        return ye0.m8298r(sb, ")", this.f2286b);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "CLParsingException (" + hashCode() + ") : " + reason();
    }
}
