package com.google.android.exoplayer2.extractor;

/* loaded from: classes.dex */
public class ForwardingExtractorInput implements ExtractorInput {

    /* renamed from: a */
    public final ExtractorInput f10090a;

    public ForwardingExtractorInput(ExtractorInput extractorInput) {
        this.f10090a = extractorInput;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean advancePeekPosition(int i, boolean z) {
        return this.f10090a.advancePeekPosition(i, z);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public long getLength() {
        return this.f10090a.getLength();
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public long getPeekPosition() {
        return this.f10090a.getPeekPosition();
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public long getPosition() {
        return this.f10090a.getPosition();
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public int peek(byte[] bArr, int i, int i2) {
        return this.f10090a.peek(bArr, i, i2);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean peekFully(byte[] bArr, int i, int i2, boolean z) {
        return this.f10090a.peekFully(bArr, i, i2, z);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput, com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) {
        return this.f10090a.read(bArr, i, i2);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean readFully(byte[] bArr, int i, int i2, boolean z) {
        return this.f10090a.readFully(bArr, i, i2, z);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void resetPeekPosition() {
        this.f10090a.resetPeekPosition();
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public <E extends Throwable> void setRetryPosition(long j, E e) {
        this.f10090a.setRetryPosition(j, e);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public int skip(int i) {
        return this.f10090a.skip(i);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean skipFully(int i, boolean z) {
        return this.f10090a.skipFully(i, z);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void advancePeekPosition(int i) {
        this.f10090a.advancePeekPosition(i);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void peekFully(byte[] bArr, int i, int i2) {
        this.f10090a.peekFully(bArr, i, i2);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void readFully(byte[] bArr, int i, int i2) {
        this.f10090a.readFully(bArr, i, i2);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void skipFully(int i) {
        this.f10090a.skipFully(i);
    }
}
