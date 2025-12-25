package p000;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* loaded from: classes.dex */
public final class gx2 implements Subtitle {

    /* renamed from: a */
    public final dx2 f17862a;

    /* renamed from: b */
    public final long[] f17863b;

    /* renamed from: c */
    public final Map f17864c;

    /* renamed from: d */
    public final HashMap f17865d;

    /* renamed from: e */
    public final HashMap f17866e;

    public gx2(dx2 dx2Var, HashMap hashMap, HashMap hashMap2, HashMap hashMap3) {
        this.f17862a = dx2Var;
        this.f17865d = hashMap2;
        this.f17866e = hashMap3;
        this.f17864c = Collections.unmodifiableMap(hashMap);
        dx2Var.getClass();
        TreeSet treeSet = new TreeSet();
        int i = 0;
        dx2Var.m4637d(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i] = ((Long) it.next()).longValue();
            i++;
        }
        this.f17863b = jArr;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public final List getCues(long j) {
        dx2 dx2Var = this.f17862a;
        dx2Var.getClass();
        ArrayList arrayList = new ArrayList();
        dx2Var.m4639g(j, dx2Var.f16596h, arrayList);
        TreeMap treeMap = new TreeMap();
        dx2Var.m4641i(j, false, dx2Var.f16596h, treeMap);
        HashMap hashMap = this.f17865d;
        dx2Var.m4640h(j, this.f17864c, hashMap, dx2Var.f16596h, treeMap);
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            String str = (String) this.f17866e.get(pair.second);
            if (str != null) {
                byte[] decode = Base64.decode(str, 0);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
                ex2 ex2Var = (ex2) Assertions.checkNotNull((ex2) hashMap.get(pair.first));
                arrayList2.add(new Cue.Builder().setBitmap(decodeByteArray).setPosition(ex2Var.f17023b).setPositionAnchor(0).setLine(ex2Var.f17024c, 0).setLineAnchor(ex2Var.f17026e).setSize(ex2Var.f17027f).setBitmapHeight(ex2Var.f17028g).setVerticalType(ex2Var.f17031j).build());
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            ex2 ex2Var2 = (ex2) Assertions.checkNotNull((ex2) hashMap.get(entry.getKey()));
            Cue.Builder builder = (Cue.Builder) entry.getValue();
            SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) Assertions.checkNotNull(builder.getText());
            for (c20 c20Var : (c20[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), c20.class)) {
                spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(c20Var), spannableStringBuilder.getSpanEnd(c20Var), (CharSequence) "");
            }
            for (int i = 0; i < spannableStringBuilder.length(); i++) {
                if (spannableStringBuilder.charAt(i) == ' ') {
                    int i2 = i + 1;
                    int i3 = i2;
                    while (i3 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i3) == ' ') {
                        i3++;
                    }
                    int i4 = i3 - i2;
                    if (i4 > 0) {
                        spannableStringBuilder.delete(i, i4 + i);
                    }
                }
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
                spannableStringBuilder.delete(0, 1);
            }
            for (int i5 = 0; i5 < spannableStringBuilder.length() - 1; i5++) {
                if (spannableStringBuilder.charAt(i5) == '\n') {
                    int i6 = i5 + 1;
                    if (spannableStringBuilder.charAt(i6) == ' ') {
                        spannableStringBuilder.delete(i6, i5 + 2);
                    }
                }
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
                spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
            }
            for (int i7 = 0; i7 < spannableStringBuilder.length() - 1; i7++) {
                if (spannableStringBuilder.charAt(i7) == ' ') {
                    int i8 = i7 + 1;
                    if (spannableStringBuilder.charAt(i8) == '\n') {
                        spannableStringBuilder.delete(i7, i8);
                    }
                }
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == '\n') {
                spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
            }
            builder.setLine(ex2Var2.f17024c, ex2Var2.f17025d);
            builder.setLineAnchor(ex2Var2.f17026e);
            builder.setPosition(ex2Var2.f17023b);
            builder.setSize(ex2Var2.f17027f);
            builder.setTextSize(ex2Var2.f17030i, ex2Var2.f17029h);
            builder.setVerticalType(ex2Var2.f17031j);
            arrayList2.add(builder.build());
        }
        return arrayList2;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public final long getEventTime(int i) {
        return this.f17863b[i];
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public final int getEventTimeCount() {
        return this.f17863b.length;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public final int getNextEventTimeIndex(long j) {
        long[] jArr = this.f17863b;
        int binarySearchCeil = Util.binarySearchCeil(jArr, j, false, false);
        if (binarySearchCeil >= jArr.length) {
            return -1;
        }
        return binarySearchCeil;
    }
}
