package com.google.android.exoplayer2.video.spherical;

import com.google.android.exoplayer2.util.Assertions;

/* loaded from: classes.dex */
public final class Projection$SubMesh {
    public static final int VIDEO_TEXTURE_ID = 0;
    public final int mode;
    public final float[] textureCoords;
    public final int textureId;
    public final float[] vertices;

    public Projection$SubMesh(int i, float[] fArr, float[] fArr2, int i2) {
        boolean z;
        this.textureId = i;
        if (fArr.length * 2 == fArr2.length * 3) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkArgument(z);
        this.vertices = fArr;
        this.textureCoords = fArr2;
        this.mode = i2;
    }

    public int getVertexCount() {
        return this.vertices.length / 3;
    }
}
