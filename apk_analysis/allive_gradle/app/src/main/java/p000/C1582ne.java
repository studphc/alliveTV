package p000;

import android.graphics.drawable.Drawable;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import androidx.constraintlayout.core.ArrayRow;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;

/* renamed from: ne */
/* loaded from: classes.dex */
public final class C1582ne implements el1 {

    /* renamed from: a */
    public int f23336a;

    /* renamed from: b */
    public Object f23337b;

    public C1582ne(int i) {
        switch (i) {
            case 3:
                this.f23337b = new ParsableByteArray(8);
                return;
            default:
                this.f23337b = new Object[256];
                return;
        }
    }

    @Override // p000.el1
    /* renamed from: a */
    public MediaCodecInfo mo4723a(int i) {
        if (((MediaCodecInfo[]) this.f23337b) == null) {
            this.f23337b = new MediaCodecList(this.f23336a).getCodecInfos();
        }
        return ((MediaCodecInfo[]) this.f23337b)[i];
    }

    /* renamed from: b */
    public Object m6343b() {
        int i = this.f23336a;
        if (i <= 0) {
            return null;
        }
        int i2 = i - 1;
        Object[] objArr = (Object[]) this.f23337b;
        Object obj = objArr[i2];
        objArr[i2] = null;
        this.f23336a = i - 1;
        return obj;
    }

    /* renamed from: c */
    public long m6344c(ExtractorInput extractorInput) {
        ParsableByteArray parsableByteArray = (ParsableByteArray) this.f23337b;
        int i = 0;
        extractorInput.peekFully(parsableByteArray.getData(), 0, 1);
        int i2 = parsableByteArray.getData()[0] & 255;
        if (i2 == 0) {
            return Long.MIN_VALUE;
        }
        int i3 = 128;
        int i4 = 0;
        while ((i2 & i3) == 0) {
            i3 >>= 1;
            i4++;
        }
        int i5 = i2 & (~i3);
        extractorInput.peekFully(parsableByteArray.getData(), 1, i4);
        while (i < i4) {
            i++;
            i5 = (parsableByteArray.getData()[i] & 255) + (i5 << 8);
        }
        this.f23336a = i4 + 1 + this.f23336a;
        return i5;
    }

    /* renamed from: d */
    public void m6345d(ArrayRow arrayRow) {
        int i = this.f23336a;
        Object[] objArr = (Object[]) this.f23337b;
        if (i < objArr.length) {
            objArr[i] = arrayRow;
            this.f23336a = i + 1;
        }
    }

    @Override // p000.el1
    /* renamed from: f */
    public boolean mo4724f(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(str);
    }

    @Override // p000.el1
    /* renamed from: k */
    public boolean mo4725k(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureRequired(str);
    }

    @Override // p000.el1
    /* renamed from: l */
    public int mo4726l() {
        if (((MediaCodecInfo[]) this.f23337b) == null) {
            this.f23337b = new MediaCodecList(this.f23336a).getCodecInfos();
        }
        return ((MediaCodecInfo[]) this.f23337b).length;
    }

    @Override // p000.el1
    /* renamed from: p */
    public boolean mo4727p() {
        return true;
    }

    public C1582ne(Drawable drawable) {
        this.f23336a = 255;
        this.f23337b = drawable;
    }
}
