package com.google.android.exoplayer2.text;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.List;
import p000.qa2;

/* loaded from: classes.dex */
public final class TextRenderer extends BaseRenderer implements Handler.Callback {

    /* renamed from: A */
    public int f11754A;

    /* renamed from: B */
    public long f11755B;

    /* renamed from: n */
    public final Handler f11756n;

    /* renamed from: o */
    public final TextOutput f11757o;

    /* renamed from: p */
    public final SubtitleDecoderFactory f11758p;

    /* renamed from: q */
    public final FormatHolder f11759q;

    /* renamed from: r */
    public boolean f11760r;

    /* renamed from: s */
    public boolean f11761s;

    /* renamed from: t */
    public boolean f11762t;

    /* renamed from: u */
    public int f11763u;

    /* renamed from: v */
    public Format f11764v;

    /* renamed from: w */
    public SubtitleDecoder f11765w;

    /* renamed from: x */
    public SubtitleInputBuffer f11766x;

    /* renamed from: y */
    public SubtitleOutputBuffer f11767y;

    /* renamed from: z */
    public SubtitleOutputBuffer f11768z;

    public TextRenderer(TextOutput textOutput, @Nullable Looper looper) {
        this(textOutput, looper, SubtitleDecoderFactory.DEFAULT);
    }

    /* renamed from: a */
    public final long m2843a() {
        if (this.f11754A == -1) {
            return Long.MAX_VALUE;
        }
        Assertions.checkNotNull(this.f11767y);
        if (this.f11754A >= this.f11767y.getEventTimeCount()) {
            return Long.MAX_VALUE;
        }
        return this.f11767y.getEventTime(this.f11754A);
    }

    /* renamed from: b */
    public final void m2844b() {
        this.f11766x = null;
        this.f11754A = -1;
        SubtitleOutputBuffer subtitleOutputBuffer = this.f11767y;
        if (subtitleOutputBuffer != null) {
            subtitleOutputBuffer.release();
            this.f11767y = null;
        }
        SubtitleOutputBuffer subtitleOutputBuffer2 = this.f11768z;
        if (subtitleOutputBuffer2 != null) {
            subtitleOutputBuffer2.release();
            this.f11768z = null;
        }
    }

    @Override // com.google.android.exoplayer2.Renderer, com.google.android.exoplayer2.RendererCapabilities
    public String getName() {
        return "TextRenderer";
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            List<Cue> list = (List) message.obj;
            TextOutput textOutput = this.f11757o;
            textOutput.onCues(list);
            textOutput.onCues(new CueGroup(list));
            return true;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return this.f11761s;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return true;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        this.f11764v = null;
        this.f11755B = C0643C.TIME_UNSET;
        List<Cue> emptyList = Collections.emptyList();
        Handler handler = this.f11756n;
        if (handler != null) {
            handler.obtainMessage(0, emptyList).sendToTarget();
        } else {
            TextOutput textOutput = this.f11757o;
            textOutput.onCues(emptyList);
            textOutput.onCues(new CueGroup(emptyList));
        }
        m2844b();
        ((SubtitleDecoder) Assertions.checkNotNull(this.f11765w)).release();
        this.f11765w = null;
        this.f11763u = 0;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long j, boolean z) {
        List<Cue> emptyList = Collections.emptyList();
        Handler handler = this.f11756n;
        if (handler != null) {
            handler.obtainMessage(0, emptyList).sendToTarget();
        } else {
            TextOutput textOutput = this.f11757o;
            textOutput.onCues(emptyList);
            textOutput.onCues(new CueGroup(emptyList));
        }
        this.f11760r = false;
        this.f11761s = false;
        this.f11755B = C0643C.TIME_UNSET;
        if (this.f11763u != 0) {
            m2844b();
            ((SubtitleDecoder) Assertions.checkNotNull(this.f11765w)).release();
            this.f11765w = null;
            this.f11763u = 0;
            this.f11762t = true;
            this.f11765w = this.f11758p.createDecoder((Format) Assertions.checkNotNull(this.f11764v));
            return;
        }
        m2844b();
        ((SubtitleDecoder) Assertions.checkNotNull(this.f11765w)).flush();
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStreamChanged(Format[] formatArr, long j, long j2) {
        Format format = formatArr[0];
        this.f11764v = format;
        if (this.f11765w != null) {
            this.f11763u = 1;
            return;
        }
        this.f11762t = true;
        this.f11765w = this.f11758p.createDecoder((Format) Assertions.checkNotNull(format));
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0149 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x014a A[EXC_TOP_SPLITTER, LOOP:1: B:60:0x014a->B:80:0x014a, LOOP_START, SYNTHETIC] */
    @Override // com.google.android.exoplayer2.Renderer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void render(long j, long j2) {
        boolean z;
        String str;
        FormatHolder formatHolder = this.f11759q;
        if (isCurrentStreamFinal()) {
            long j3 = this.f11755B;
            if (j3 != C0643C.TIME_UNSET && j >= j3) {
                m2844b();
                this.f11761s = true;
            }
        }
        if (this.f11761s) {
            return;
        }
        SubtitleOutputBuffer subtitleOutputBuffer = this.f11768z;
        SubtitleDecoderFactory subtitleDecoderFactory = this.f11758p;
        TextOutput textOutput = this.f11757o;
        Handler handler = this.f11756n;
        if (subtitleOutputBuffer == null) {
            ((SubtitleDecoder) Assertions.checkNotNull(this.f11765w)).setPositionUs(j);
            try {
                this.f11768z = ((SubtitleDecoder) Assertions.checkNotNull(this.f11765w)).dequeueOutputBuffer();
            } catch (SubtitleDecoderException e) {
                Log.m3024e("TextRenderer", "Subtitle decoding failed. streamFormat=" + this.f11764v, e);
                List<Cue> emptyList = Collections.emptyList();
                if (handler != null) {
                    handler.obtainMessage(0, emptyList).sendToTarget();
                } else {
                    textOutput.onCues(emptyList);
                    textOutput.onCues(new CueGroup(emptyList));
                }
                m2844b();
                ((SubtitleDecoder) Assertions.checkNotNull(this.f11765w)).release();
                this.f11765w = null;
                this.f11763u = 0;
                this.f11762t = true;
                this.f11765w = subtitleDecoderFactory.createDecoder((Format) Assertions.checkNotNull(this.f11764v));
                return;
            }
        }
        if (getState() != 2) {
            return;
        }
        if (this.f11767y != null) {
            long m2843a = m2843a();
            z = false;
            while (m2843a <= j) {
                this.f11754A++;
                m2843a = m2843a();
                z = true;
            }
        } else {
            z = false;
        }
        SubtitleOutputBuffer subtitleOutputBuffer2 = this.f11768z;
        if (subtitleOutputBuffer2 != null) {
            if (!subtitleOutputBuffer2.isEndOfStream()) {
                str = "TextRenderer";
                if (subtitleOutputBuffer2.timeUs <= j) {
                    SubtitleOutputBuffer subtitleOutputBuffer3 = this.f11767y;
                    if (subtitleOutputBuffer3 != null) {
                        subtitleOutputBuffer3.release();
                    }
                    this.f11754A = subtitleOutputBuffer2.getNextEventTimeIndex(j);
                    this.f11767y = subtitleOutputBuffer2;
                    this.f11768z = null;
                    z = true;
                }
                if (z) {
                    Assertions.checkNotNull(this.f11767y);
                    List<Cue> cues = this.f11767y.getCues(j);
                    if (handler != null) {
                        handler.obtainMessage(0, cues).sendToTarget();
                    } else {
                        textOutput.onCues(cues);
                        textOutput.onCues(new CueGroup(cues));
                    }
                }
                if (this.f11763u != 2) {
                    return;
                }
                while (!this.f11760r) {
                    try {
                        SubtitleInputBuffer subtitleInputBuffer = this.f11766x;
                        if (subtitleInputBuffer == null) {
                            subtitleInputBuffer = ((SubtitleDecoder) Assertions.checkNotNull(this.f11765w)).dequeueInputBuffer();
                            if (subtitleInputBuffer == null) {
                                return;
                            } else {
                                this.f11766x = subtitleInputBuffer;
                            }
                        }
                        if (this.f11763u == 1) {
                            subtitleInputBuffer.setFlags(4);
                            ((SubtitleDecoder) Assertions.checkNotNull(this.f11765w)).queueInputBuffer(subtitleInputBuffer);
                            this.f11766x = null;
                            this.f11763u = 2;
                            return;
                        }
                        int readSource = readSource(formatHolder, subtitleInputBuffer, 0);
                        if (readSource == -4) {
                            if (subtitleInputBuffer.isEndOfStream()) {
                                this.f11760r = true;
                                this.f11762t = false;
                            } else {
                                Format format = formatHolder.format;
                                if (format == null) {
                                    return;
                                }
                                subtitleInputBuffer.subsampleOffsetUs = format.subsampleOffsetUs;
                                subtitleInputBuffer.flip();
                                this.f11762t &= !subtitleInputBuffer.isKeyFrame();
                            }
                            if (!this.f11762t) {
                                ((SubtitleDecoder) Assertions.checkNotNull(this.f11765w)).queueInputBuffer(subtitleInputBuffer);
                                this.f11766x = null;
                            }
                        } else if (readSource == -3) {
                            return;
                        }
                    } catch (SubtitleDecoderException e2) {
                        Log.m3024e(str, "Subtitle decoding failed. streamFormat=" + this.f11764v, e2);
                        List<Cue> emptyList2 = Collections.emptyList();
                        if (handler != null) {
                            handler.obtainMessage(0, emptyList2).sendToTarget();
                        } else {
                            textOutput.onCues(emptyList2);
                            textOutput.onCues(new CueGroup(emptyList2));
                        }
                        m2844b();
                        ((SubtitleDecoder) Assertions.checkNotNull(this.f11765w)).release();
                        this.f11765w = null;
                        this.f11763u = 0;
                        this.f11762t = true;
                        this.f11765w = subtitleDecoderFactory.createDecoder((Format) Assertions.checkNotNull(this.f11764v));
                        return;
                    }
                }
                return;
            }
            if (!z && m2843a() == Long.MAX_VALUE) {
                if (this.f11763u == 2) {
                    m2844b();
                    ((SubtitleDecoder) Assertions.checkNotNull(this.f11765w)).release();
                    this.f11765w = null;
                    this.f11763u = 0;
                    this.f11762t = true;
                    this.f11765w = subtitleDecoderFactory.createDecoder((Format) Assertions.checkNotNull(this.f11764v));
                } else {
                    m2844b();
                    this.f11761s = true;
                }
            }
        }
        str = "TextRenderer";
        if (z) {
        }
        if (this.f11763u != 2) {
        }
    }

    public void setFinalStreamEndPositionUs(long j) {
        Assertions.checkState(isCurrentStreamFinal());
        this.f11755B = j;
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public int supportsFormat(Format format) {
        int i;
        if (this.f11758p.supportsFormat(format)) {
            if (format.cryptoType == 0) {
                i = 4;
            } else {
                i = 2;
            }
            return qa2.m7011a(i);
        }
        if (MimeTypes.isText(format.sampleMimeType)) {
            return qa2.m7011a(1);
        }
        return qa2.m7011a(0);
    }

    public TextRenderer(TextOutput textOutput, @Nullable Looper looper, SubtitleDecoderFactory subtitleDecoderFactory) {
        super(3);
        this.f11757o = (TextOutput) Assertions.checkNotNull(textOutput);
        this.f11756n = looper == null ? null : Util.createHandler(looper, this);
        this.f11758p = subtitleDecoderFactory;
        this.f11759q = new FormatHolder();
        this.f11755B = C0643C.TIME_UNSET;
    }
}
