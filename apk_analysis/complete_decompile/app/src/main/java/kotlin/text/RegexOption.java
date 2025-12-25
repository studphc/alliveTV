package kotlin.text;

import kotlin.Metadata;

@Metadata(m5568d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\n\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, m5569d2 = {"Lkotlin/text/RegexOption;", "", "", "a", "I", "getValue", "()I", "value", "b", "getMask", "mask", "IGNORE_CASE", "MULTILINE", "LITERAL", "UNIX_LINES", "COMMENTS", "DOT_MATCHES_ALL", "CANON_EQ", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public enum RegexOption {
    IGNORE_CASE(2),
    MULTILINE(8),
    LITERAL(16),
    UNIX_LINES(1),
    COMMENTS(4),
    DOT_MATCHES_ALL(32),
    CANON_EQ(128);


    /* renamed from: a, reason: from kotlin metadata */
    public final int value;

    /* renamed from: b, reason: from kotlin metadata */
    public final int mask;

    RegexOption(int i) {
        this.value = i;
        this.mask = i;
    }

    public int getMask() {
        return this.mask;
    }

    public int getValue() {
        return this.value;
    }
}
