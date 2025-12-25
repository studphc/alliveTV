package com.google.common.xml;

import com.google.common.annotations.GwtCompatible;
import com.google.common.escape.Escaper;
import com.google.common.escape.Escapers;
import kotlin.text.Typography;
import okio.Utf8;

@GwtCompatible
/* loaded from: classes2.dex */
public class XmlEscapers {

    /* renamed from: a */
    public static final Escaper f15448a;

    /* renamed from: b */
    public static final Escaper f15449b;

    static {
        Escapers.Builder builder = Escapers.builder();
        builder.setSafeRange((char) 0, Utf8.REPLACEMENT_CHARACTER);
        builder.setUnsafeReplacement("�");
        for (char c = 0; c <= 31; c = (char) (c + 1)) {
            if (c != '\t' && c != '\n' && c != '\r') {
                builder.addEscape(c, "�");
            }
        }
        builder.addEscape(Typography.amp, "&amp;");
        builder.addEscape(Typography.less, "&lt;");
        builder.addEscape(Typography.greater, "&gt;");
        f15448a = builder.build();
        builder.addEscape('\'', "&apos;");
        builder.addEscape(Typography.quote, "&quot;");
        builder.build();
        builder.addEscape('\t', "&#x9;");
        builder.addEscape('\n', "&#xA;");
        builder.addEscape('\r', "&#xD;");
        f15449b = builder.build();
    }

    public static Escaper xmlAttributeEscaper() {
        return f15449b;
    }

    public static Escaper xmlContentEscaper() {
        return f15448a;
    }
}
