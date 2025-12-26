package p000;

import com.google.common.base.Ascii;
import com.google.common.base.CaseFormat;

/* renamed from: ll */
/* loaded from: classes.dex */
public enum C1515ll extends CaseFormat {
    @Override // com.google.common.base.CaseFormat
    /* renamed from: b */
    public final String mo3753b(CaseFormat caseFormat, String str) {
        if (caseFormat == CaseFormat.LOWER_HYPHEN) {
            return Ascii.toLowerCase(str.replace('_', '-'));
        }
        if (caseFormat == CaseFormat.LOWER_UNDERSCORE) {
            return Ascii.toLowerCase(str);
        }
        return super.mo3753b(caseFormat, str);
    }

    @Override // com.google.common.base.CaseFormat
    /* renamed from: d */
    public final String mo3755d(String str) {
        return Ascii.toUpperCase(str);
    }
}
