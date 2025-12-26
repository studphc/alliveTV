package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import com.google.android.exoplayer2.util.Util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class GaplessInfoHolder {

    /* renamed from: a */
    public static final Pattern f10091a = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int encoderDelay = -1;
    public int encoderPadding = -1;

    /* renamed from: a */
    public final boolean m2534a(String str) {
        Matcher matcher = f10091a.matcher(str);
        if (matcher.find()) {
            try {
                int parseInt = Integer.parseInt((String) Util.castNonNull(matcher.group(1)), 16);
                int parseInt2 = Integer.parseInt((String) Util.castNonNull(matcher.group(2)), 16);
                if (parseInt > 0 || parseInt2 > 0) {
                    this.encoderDelay = parseInt;
                    this.encoderPadding = parseInt2;
                    return true;
                }
                return false;
            } catch (NumberFormatException unused) {
                return false;
            }
        }
        return false;
    }

    public boolean hasGaplessInfo() {
        if (this.encoderDelay != -1 && this.encoderPadding != -1) {
            return true;
        }
        return false;
    }

    public boolean setFromMetadata(Metadata metadata) {
        for (int i = 0; i < metadata.length(); i++) {
            Metadata.Entry entry = metadata.get(i);
            if (entry instanceof CommentFrame) {
                CommentFrame commentFrame = (CommentFrame) entry;
                if ("iTunSMPB".equals(commentFrame.description) && m2534a(commentFrame.text)) {
                    return true;
                }
            } else if (entry instanceof InternalFrame) {
                InternalFrame internalFrame = (InternalFrame) entry;
                if ("com.apple.iTunes".equals(internalFrame.domain) && "iTunSMPB".equals(internalFrame.description) && m2534a(internalFrame.text)) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public boolean setFromXingHeaderValue(int i) {
        int i2 = i >> 12;
        int i3 = i & 4095;
        if (i2 <= 0 && i3 <= 0) {
            return false;
        }
        this.encoderDelay = i2;
        this.encoderPadding = i3;
        return true;
    }
}
