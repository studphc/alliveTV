package com.google.android.exoplayer2.text.dvb;

import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.List;
import p000.o70;

/* loaded from: classes.dex */
public final class DvbDecoder extends SimpleSubtitleDecoder {

    /* renamed from: o */
    public final o70 f11805o;

    public DvbDecoder(List<byte[]> list) {
        super("DvbDecoder");
        ParsableByteArray parsableByteArray = new ParsableByteArray(list.get(0));
        this.f11805o = new o70(parsableByteArray.readUnsignedShort(), parsableByteArray.readUnsignedShort());
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r3v0 vl, still in use, count: 2, list:
          (r3v0 vl) from 0x0275: PHI (r3v1 vl) = (r3v0 vl), (r3v5 vl) binds: [B:92:0x026f, B:132:0x03a3] A[DONT_GENERATE, DONT_INLINE]
          (r3v0 vl) from 0x0236: MOVE (r33v5 vl) = (r3v0 vl) (LINE:567)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:151)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:116)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:80)
        	at jadx.core.utils.InsnRemover.addAndUnbind(InsnRemover.java:56)
        	at jadx.core.dex.visitors.ModVisitor.removeStep(ModVisitor.java:447)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    /* JADX WARN: Type inference failed for: r6v5, types: [oc, java.lang.Object] */
    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public com.google.android.exoplayer2.text.Subtitle decode(byte[] r31, int r32, boolean r33) {
        /*
            Method dump skipped, instructions count: 1048
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.dvb.DvbDecoder.decode(byte[], int, boolean):com.google.android.exoplayer2.text.Subtitle");
    }
}
