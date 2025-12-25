package androidx.core.graphics;

import android.graphics.Path;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import p000.AbstractC1726qj;
import p000.ye0;

/* loaded from: classes.dex */
public final class PathParser {
    /* renamed from: a */
    public static float[] m831a(int i, float[] fArr) {
        if (i >= 0) {
            int length = fArr.length;
            if (length >= 0) {
                int min = Math.min(i, length);
                float[] fArr2 = new float[i];
                System.arraycopy(fArr, 0, fArr2, 0, min);
                return fArr2;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        throw new IllegalArgumentException();
    }

    public static boolean canMorph(@Nullable PathDataNode[] pathDataNodeArr, @Nullable PathDataNode[] pathDataNodeArr2) {
        if (pathDataNodeArr == null || pathDataNodeArr2 == null || pathDataNodeArr.length != pathDataNodeArr2.length) {
            return false;
        }
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            PathDataNode pathDataNode = pathDataNodeArr[i];
            char c = pathDataNode.f3637a;
            PathDataNode pathDataNode2 = pathDataNodeArr2[i];
            if (c != pathDataNode2.f3637a || pathDataNode.f3638b.length != pathDataNode2.f3638b.length) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:31:0x007a. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0096 A[Catch: NumberFormatException -> 0x00aa, LOOP:3: B:25:0x0068->B:35:0x0096, LOOP_END, TryCatch #0 {NumberFormatException -> 0x00aa, blocks: (B:22:0x0054, B:25:0x0068, B:27:0x006e, B:31:0x007a, B:35:0x0096, B:39:0x009c, B:44:0x00b1, B:56:0x00b4), top: B:21:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0095 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x009c A[Catch: NumberFormatException -> 0x00aa, TryCatch #0 {NumberFormatException -> 0x00aa, blocks: (B:22:0x0054, B:25:0x0068, B:27:0x006e, B:31:0x007a, B:35:0x0096, B:39:0x009c, B:44:0x00b1, B:56:0x00b4), top: B:21:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b1 A[Catch: NumberFormatException -> 0x00aa, TryCatch #0 {NumberFormatException -> 0x00aa, blocks: (B:22:0x0054, B:25:0x0068, B:27:0x006e, B:31:0x007a, B:35:0x0096, B:39:0x009c, B:44:0x00b1, B:56:0x00b4), top: B:21:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d7 A[SYNTHETIC] */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static PathDataNode[] createNodesFromPathData(@NonNull String str) {
        int i;
        String trim;
        float[] fArr;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i4 < str.length()) {
            while (i4 < str.length()) {
                char charAt = str.charAt(i4);
                if ((charAt - 'Z') * (charAt - 'A') > 0) {
                    if ((charAt - 'z') * (charAt - 'a') > 0) {
                        continue;
                        i4++;
                    }
                }
                if (charAt != 'e' && charAt != 'E') {
                    trim = str.substring(i3, i4).trim();
                    if (!trim.isEmpty()) {
                        if (trim.charAt(i2) != 'z' && trim.charAt(i2) != 'Z') {
                            try {
                                float[] fArr2 = new float[trim.length()];
                                int length = trim.length();
                                int i5 = i2;
                                int i6 = 1;
                                while (i6 < length) {
                                    int i7 = i2;
                                    int i8 = i7;
                                    int i9 = i8;
                                    int i10 = i9;
                                    for (int i11 = i6; i11 < trim.length(); i11++) {
                                        char charAt2 = trim.charAt(i11);
                                        if (charAt2 != ' ') {
                                            if (charAt2 != 'E' && charAt2 != 'e') {
                                                switch (charAt2) {
                                                    case ',':
                                                        break;
                                                    case '-':
                                                        if (i11 != i6 && i7 == 0) {
                                                            i7 = 0;
                                                            i9 = 1;
                                                            i10 = 1;
                                                            break;
                                                        }
                                                        i7 = 0;
                                                        break;
                                                    case '.':
                                                        if (i8 == 0) {
                                                            i7 = 0;
                                                            i8 = 1;
                                                            break;
                                                        }
                                                        i7 = 0;
                                                        i9 = 1;
                                                        i10 = 1;
                                                        break;
                                                    default:
                                                        i7 = 0;
                                                        break;
                                                }
                                            } else {
                                                i7 = 1;
                                            }
                                            if (i9 == 0) {
                                                if (i6 < i11) {
                                                    fArr2[i5] = Float.parseFloat(trim.substring(i6, i11));
                                                    i5++;
                                                }
                                                if (i10 == 0) {
                                                    i6 = i11;
                                                } else {
                                                    i6 = i11 + 1;
                                                }
                                                i2 = 0;
                                            }
                                        }
                                        i7 = 0;
                                        i9 = 1;
                                        if (i9 == 0) {
                                        }
                                    }
                                    if (i6 < i11) {
                                    }
                                    if (i10 == 0) {
                                    }
                                    i2 = 0;
                                }
                                fArr = m831a(i5, fArr2);
                                i2 = 0;
                            } catch (NumberFormatException e) {
                                throw new RuntimeException(ye0.m8296p("error in parsing \"", trim, "\""), e);
                            }
                        } else {
                            fArr = new float[i2];
                        }
                        arrayList.add(new PathDataNode(trim.charAt(i2), fArr));
                    }
                    i3 = i4;
                    i4++;
                    i2 = 0;
                }
                i4++;
            }
            trim = str.substring(i3, i4).trim();
            if (!trim.isEmpty()) {
            }
            i3 = i4;
            i4++;
            i2 = 0;
        }
        if (i4 - i3 == 1 && i3 < str.length()) {
            i = 0;
            arrayList.add(new PathDataNode(str.charAt(i3), new float[0]));
        } else {
            i = 0;
        }
        return (PathDataNode[]) arrayList.toArray(new PathDataNode[i]);
    }

    @NonNull
    public static Path createPathFromPathData(@NonNull String str) {
        Path path = new Path();
        try {
            PathDataNode.nodesToPath(createNodesFromPathData(str), path);
            return path;
        } catch (RuntimeException e) {
            throw new RuntimeException(AbstractC1726qj.m7038C("Error in parsing ", str), e);
        }
    }

    @NonNull
    public static PathDataNode[] deepCopyNodes(@NonNull PathDataNode[] pathDataNodeArr) {
        PathDataNode[] pathDataNodeArr2 = new PathDataNode[pathDataNodeArr.length];
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            pathDataNodeArr2[i] = new PathDataNode(pathDataNodeArr[i]);
        }
        return pathDataNodeArr2;
    }

    public static void interpolatePathDataNodes(@NonNull PathDataNode[] pathDataNodeArr, float f, @NonNull PathDataNode[] pathDataNodeArr2, @NonNull PathDataNode[] pathDataNodeArr3) {
        if (!interpolatePathDataNodes(pathDataNodeArr, pathDataNodeArr2, pathDataNodeArr3, f)) {
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
    }

    public static void nodesToPath(@NonNull PathDataNode[] pathDataNodeArr, @NonNull Path path) {
        int i;
        int i2;
        char c;
        int i3;
        int i4;
        PathDataNode pathDataNode;
        boolean z;
        boolean z2;
        float f;
        float f2;
        boolean z3;
        boolean z4;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        PathDataNode[] pathDataNodeArr2 = pathDataNodeArr;
        int i5 = 6;
        float[] fArr = new float[6];
        int length = pathDataNodeArr2.length;
        int i6 = 0;
        char c2 = 'm';
        while (i6 < length) {
            PathDataNode pathDataNode2 = pathDataNodeArr2[i6];
            char c3 = pathDataNode2.f3637a;
            float f13 = fArr[0];
            float f14 = fArr[1];
            float f15 = fArr[2];
            float f16 = fArr[3];
            float f17 = fArr[4];
            float f18 = fArr[5];
            switch (c3) {
                case 'A':
                case 'a':
                    i = 7;
                    break;
                case 'C':
                case 'c':
                    i = i5;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i = 1;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path.moveTo(f17, f18);
                    f13 = f17;
                    f15 = f13;
                    f14 = f18;
                    f16 = f14;
                    break;
            }
            i = 2;
            float f19 = f17;
            float f20 = f18;
            float f21 = f13;
            float f22 = f14;
            int i7 = 0;
            while (true) {
                float[] fArr2 = pathDataNode2.f3638b;
                if (i7 < fArr2.length) {
                    if (c3 != 'A') {
                        if (c3 != 'C') {
                            if (c3 != 'H') {
                                if (c3 != 'Q') {
                                    if (c3 != 'V') {
                                        if (c3 != 'a') {
                                            if (c3 != 'c') {
                                                if (c3 != 'h') {
                                                    if (c3 != 'q') {
                                                        if (c3 != 'v') {
                                                            if (c3 != 'L') {
                                                                if (c3 != 'M') {
                                                                    if (c3 != 'S') {
                                                                        if (c3 != 'T') {
                                                                            if (c3 != 'l') {
                                                                                if (c3 != 'm') {
                                                                                    if (c3 != 's') {
                                                                                        if (c3 != 't') {
                                                                                            i2 = i7;
                                                                                        } else {
                                                                                            if (c2 != 'q' && c2 != 't' && c2 != 'Q' && c2 != 'T') {
                                                                                                f12 = RecyclerView.f7068F0;
                                                                                                f11 = RecyclerView.f7068F0;
                                                                                            } else {
                                                                                                f11 = f21 - f15;
                                                                                                f12 = f22 - f16;
                                                                                            }
                                                                                            int i8 = i7 + 1;
                                                                                            path.rQuadTo(f11, f12, fArr2[i7], fArr2[i8]);
                                                                                            float f23 = f11 + f21;
                                                                                            float f24 = f12 + f22;
                                                                                            f21 += fArr2[i7];
                                                                                            f22 += fArr2[i8];
                                                                                            f16 = f24;
                                                                                            i2 = i7;
                                                                                            c = c3;
                                                                                            i3 = i6;
                                                                                            i4 = length;
                                                                                            f15 = f23;
                                                                                        }
                                                                                    } else {
                                                                                        if (c2 != 'c' && c2 != 's' && c2 != 'C' && c2 != 'S') {
                                                                                            f9 = RecyclerView.f7068F0;
                                                                                            f10 = RecyclerView.f7068F0;
                                                                                        } else {
                                                                                            float f25 = f21 - f15;
                                                                                            f9 = f22 - f16;
                                                                                            f10 = f25;
                                                                                        }
                                                                                        int i9 = i7 + 1;
                                                                                        int i10 = i7 + 2;
                                                                                        int i11 = i7 + 3;
                                                                                        i2 = i7;
                                                                                        float f26 = f22;
                                                                                        float f27 = f21;
                                                                                        path.rCubicTo(f10, f9, fArr2[i7], fArr2[i9], fArr2[i10], fArr2[i11]);
                                                                                        f3 = f27 + fArr2[i2];
                                                                                        f4 = f26 + fArr2[i9];
                                                                                        f5 = f27 + fArr2[i10];
                                                                                        f6 = fArr2[i11] + f26;
                                                                                    }
                                                                                } else {
                                                                                    i2 = i7;
                                                                                    float f28 = fArr2[i2];
                                                                                    f21 += f28;
                                                                                    float f29 = fArr2[i2 + 1];
                                                                                    f22 += f29;
                                                                                    if (i2 > 0) {
                                                                                        path.rLineTo(f28, f29);
                                                                                    } else {
                                                                                        path.rMoveTo(f28, f29);
                                                                                        f20 = f22;
                                                                                        f19 = f21;
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                i2 = i7;
                                                                                int i12 = i2 + 1;
                                                                                path.rLineTo(fArr2[i2], fArr2[i12]);
                                                                                f21 += fArr2[i2];
                                                                                f22 += fArr2[i12];
                                                                            }
                                                                        } else {
                                                                            i2 = i7;
                                                                            float f30 = f22;
                                                                            float f31 = f21;
                                                                            if (c2 != 'q' && c2 != 't' && c2 != 'Q' && c2 != 'T') {
                                                                                f3 = f31;
                                                                                f4 = f30;
                                                                            } else {
                                                                                f3 = (f31 * 2.0f) - f15;
                                                                                f4 = (f30 * 2.0f) - f16;
                                                                            }
                                                                            int i13 = i2 + 1;
                                                                            path.quadTo(f3, f4, fArr2[i2], fArr2[i13]);
                                                                            f5 = fArr2[i2];
                                                                            f6 = fArr2[i13];
                                                                        }
                                                                    } else {
                                                                        i2 = i7;
                                                                        float f32 = f22;
                                                                        float f33 = f21;
                                                                        if (c2 != 'c' && c2 != 's' && c2 != 'C' && c2 != 'S') {
                                                                            f8 = f33;
                                                                            f7 = f32;
                                                                        } else {
                                                                            f7 = (f32 * 2.0f) - f16;
                                                                            f8 = (f33 * 2.0f) - f15;
                                                                        }
                                                                        int i14 = i2 + 1;
                                                                        int i15 = i2 + 2;
                                                                        int i16 = i2 + 3;
                                                                        path.cubicTo(f8, f7, fArr2[i2], fArr2[i14], fArr2[i15], fArr2[i16]);
                                                                        float f34 = fArr2[i2];
                                                                        float f35 = fArr2[i14];
                                                                        f21 = fArr2[i15];
                                                                        f22 = fArr2[i16];
                                                                        f16 = f35;
                                                                        f15 = f34;
                                                                    }
                                                                } else {
                                                                    i2 = i7;
                                                                    f21 = fArr2[i2];
                                                                    f22 = fArr2[i2 + 1];
                                                                    if (i2 > 0) {
                                                                        path.lineTo(f21, f22);
                                                                    } else {
                                                                        path.moveTo(f21, f22);
                                                                        f20 = f22;
                                                                        f19 = f21;
                                                                    }
                                                                }
                                                            } else {
                                                                i2 = i7;
                                                                int i17 = i2 + 1;
                                                                path.lineTo(fArr2[i2], fArr2[i17]);
                                                                f21 = fArr2[i2];
                                                                f22 = fArr2[i17];
                                                            }
                                                        } else {
                                                            i2 = i7;
                                                            path.rLineTo(RecyclerView.f7068F0, fArr2[i2]);
                                                            f22 += fArr2[i2];
                                                        }
                                                    } else {
                                                        i2 = i7;
                                                        float f36 = f22;
                                                        float f37 = f21;
                                                        int i18 = i2 + 1;
                                                        int i19 = i2 + 2;
                                                        int i20 = i2 + 3;
                                                        path.rQuadTo(fArr2[i2], fArr2[i18], fArr2[i19], fArr2[i20]);
                                                        float f38 = f37 + fArr2[i2];
                                                        float f39 = fArr2[i18] + f36;
                                                        float f40 = f37 + fArr2[i19];
                                                        f22 = f36 + fArr2[i20];
                                                        f16 = f39;
                                                        f15 = f38;
                                                        c = c3;
                                                        i3 = i6;
                                                        i4 = length;
                                                        f21 = f40;
                                                    }
                                                    pathDataNode = pathDataNode2;
                                                } else {
                                                    i2 = i7;
                                                    path.rLineTo(fArr2[i2], RecyclerView.f7068F0);
                                                    f21 += fArr2[i2];
                                                }
                                                c = c3;
                                                i3 = i6;
                                                i4 = length;
                                                pathDataNode = pathDataNode2;
                                            } else {
                                                i2 = i7;
                                                float f41 = f22;
                                                float f42 = f21;
                                                int i21 = i2 + 2;
                                                int i22 = i2 + 3;
                                                int i23 = i2 + 4;
                                                int i24 = i2 + 5;
                                                path.rCubicTo(fArr2[i2], fArr2[i2 + 1], fArr2[i21], fArr2[i22], fArr2[i23], fArr2[i24]);
                                                f3 = f42 + fArr2[i21];
                                                f4 = f41 + fArr2[i22];
                                                f5 = f42 + fArr2[i23];
                                                f6 = fArr2[i24] + f41;
                                            }
                                            f16 = f4;
                                            f15 = f3;
                                            c = c3;
                                            i3 = i6;
                                            i4 = length;
                                            f21 = f5;
                                            f22 = f6;
                                            pathDataNode = pathDataNode2;
                                        } else {
                                            i2 = i7;
                                            float f43 = f22;
                                            float f44 = f21;
                                            int i25 = i2 + 5;
                                            float f45 = fArr2[i25] + f44;
                                            int i26 = i2 + 6;
                                            float f46 = fArr2[i26] + f43;
                                            float f47 = fArr2[i2];
                                            float f48 = fArr2[i2 + 1];
                                            float f49 = fArr2[i2 + 2];
                                            if (fArr2[i2 + 3] != RecyclerView.f7068F0) {
                                                z3 = true;
                                            } else {
                                                z3 = false;
                                            }
                                            if (fArr2[i2 + 4] != RecyclerView.f7068F0) {
                                                z4 = true;
                                            } else {
                                                z4 = false;
                                            }
                                            c = c3;
                                            i4 = length;
                                            pathDataNode = pathDataNode2;
                                            i3 = i6;
                                            PathDataNode.m832a(path, f44, f43, f45, f46, f47, f48, f49, z3, z4);
                                            f21 = f44 + fArr2[i25];
                                            f22 = f43 + fArr2[i26];
                                        }
                                    } else {
                                        i2 = i7;
                                        c = c3;
                                        i3 = i6;
                                        i4 = length;
                                        pathDataNode = pathDataNode2;
                                        path.lineTo(f21, fArr2[i2]);
                                        f22 = fArr2[i2];
                                    }
                                } else {
                                    i2 = i7;
                                    c = c3;
                                    i3 = i6;
                                    i4 = length;
                                    pathDataNode = pathDataNode2;
                                    float f50 = fArr2[i2];
                                    int i27 = i2 + 1;
                                    float f51 = fArr2[i27];
                                    int i28 = i2 + 2;
                                    int i29 = i2 + 3;
                                    path.quadTo(f50, f51, fArr2[i28], fArr2[i29]);
                                    f = fArr2[i2];
                                    f2 = fArr2[i27];
                                    f21 = fArr2[i28];
                                    f22 = fArr2[i29];
                                }
                            } else {
                                i2 = i7;
                                c = c3;
                                i3 = i6;
                                i4 = length;
                                pathDataNode = pathDataNode2;
                                path.lineTo(fArr2[i2], f22);
                                f21 = fArr2[i2];
                            }
                            i7 = i2 + i;
                            pathDataNode2 = pathDataNode;
                            length = i4;
                            c2 = c;
                            c3 = c2;
                            i6 = i3;
                        } else {
                            i2 = i7;
                            c = c3;
                            i3 = i6;
                            i4 = length;
                            pathDataNode = pathDataNode2;
                            int i30 = i2 + 2;
                            int i31 = i2 + 3;
                            int i32 = i2 + 4;
                            int i33 = i2 + 5;
                            path.cubicTo(fArr2[i2], fArr2[i2 + 1], fArr2[i30], fArr2[i31], fArr2[i32], fArr2[i33]);
                            f21 = fArr2[i32];
                            f22 = fArr2[i33];
                            f = fArr2[i30];
                            f2 = fArr2[i31];
                        }
                        f15 = f;
                        f16 = f2;
                        i7 = i2 + i;
                        pathDataNode2 = pathDataNode;
                        length = i4;
                        c2 = c;
                        c3 = c2;
                        i6 = i3;
                    } else {
                        i2 = i7;
                        float f52 = f22;
                        float f53 = f21;
                        c = c3;
                        i3 = i6;
                        i4 = length;
                        pathDataNode = pathDataNode2;
                        int i34 = i2 + 5;
                        float f54 = fArr2[i34];
                        int i35 = i2 + 6;
                        float f55 = fArr2[i35];
                        float f56 = fArr2[i2];
                        float f57 = fArr2[i2 + 1];
                        float f58 = fArr2[i2 + 2];
                        if (fArr2[i2 + 3] != RecyclerView.f7068F0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (fArr2[i2 + 4] != RecyclerView.f7068F0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        PathDataNode.m832a(path, f53, f52, f54, f55, f56, f57, f58, z, z2);
                        f21 = fArr2[i34];
                        f22 = fArr2[i35];
                    }
                    f16 = f22;
                    f15 = f21;
                    i7 = i2 + i;
                    pathDataNode2 = pathDataNode;
                    length = i4;
                    c2 = c;
                    c3 = c2;
                    i6 = i3;
                }
            }
            fArr[0] = f21;
            fArr[1] = f22;
            fArr[2] = f15;
            fArr[3] = f16;
            fArr[4] = f19;
            fArr[5] = f20;
            c2 = pathDataNode2.f3637a;
            i6++;
            pathDataNodeArr2 = pathDataNodeArr;
            length = length;
            i5 = 6;
        }
    }

    public static void updateNodes(@NonNull PathDataNode[] pathDataNodeArr, @NonNull PathDataNode[] pathDataNodeArr2) {
        for (int i = 0; i < pathDataNodeArr2.length; i++) {
            pathDataNodeArr[i].f3637a = pathDataNodeArr2[i].f3637a;
            int i2 = 0;
            while (true) {
                float[] fArr = pathDataNodeArr2[i].f3638b;
                if (i2 < fArr.length) {
                    pathDataNodeArr[i].f3638b[i2] = fArr[i2];
                    i2++;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class PathDataNode {

        /* renamed from: a */
        public char f3637a;

        /* renamed from: b */
        public final float[] f3638b;

        public PathDataNode(char c, float[] fArr) {
            this.f3637a = c;
            this.f3638b = fArr;
        }

        /* renamed from: a */
        public static void m832a(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
            double d;
            double d2;
            boolean z3;
            double radians = Math.toRadians(f7);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d3 = f;
            double d4 = f2;
            double d5 = (d4 * sin) + (d3 * cos);
            double d6 = d3;
            double d7 = f5;
            double d8 = d5 / d7;
            double d9 = f6;
            double d10 = ((d4 * cos) + ((-f) * sin)) / d9;
            double d11 = d4;
            double d12 = f4;
            double d13 = ((d12 * sin) + (f3 * cos)) / d7;
            double d14 = ((d12 * cos) + ((-f3) * sin)) / d9;
            double d15 = d8 - d13;
            double d16 = d10 - d14;
            double d17 = (d8 + d13) / 2.0d;
            double d18 = (d10 + d14) / 2.0d;
            double d19 = (d16 * d16) + (d15 * d15);
            if (d19 == 0.0d) {
                Log.w("PathParser", " Points are coincident");
                return;
            }
            double d20 = (1.0d / d19) - 0.25d;
            if (d20 < 0.0d) {
                Log.w("PathParser", "Points are too far apart " + d19);
                float sqrt = (float) (Math.sqrt(d19) / 1.99999d);
                m832a(path, f, f2, f3, f4, f5 * sqrt, f6 * sqrt, f7, z, z2);
                return;
            }
            double sqrt2 = Math.sqrt(d20);
            double d21 = d15 * sqrt2;
            double d22 = sqrt2 * d16;
            if (z == z2) {
                d = d17 - d22;
                d2 = d18 + d21;
            } else {
                d = d17 + d22;
                d2 = d18 - d21;
            }
            double atan2 = Math.atan2(d10 - d2, d8 - d);
            double atan22 = Math.atan2(d14 - d2, d13 - d) - atan2;
            if (atan22 >= 0.0d) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z2 != z3) {
                if (atan22 > 0.0d) {
                    atan22 -= 6.283185307179586d;
                } else {
                    atan22 += 6.283185307179586d;
                }
            }
            double d23 = d * d7;
            double d24 = d2 * d9;
            double d25 = (d23 * cos) - (d24 * sin);
            double d26 = (d24 * cos) + (d23 * sin);
            int ceil = (int) Math.ceil(Math.abs((atan22 * 4.0d) / 3.141592653589793d));
            double cos2 = Math.cos(radians);
            double sin2 = Math.sin(radians);
            double cos3 = Math.cos(atan2);
            double sin3 = Math.sin(atan2);
            double d27 = -d7;
            double d28 = d27 * cos2;
            double d29 = d9 * sin2;
            double d30 = (d28 * sin3) - (d29 * cos3);
            double d31 = d27 * sin2;
            double d32 = d9 * cos2;
            double d33 = (cos3 * d32) + (sin3 * d31);
            double d34 = d32;
            double d35 = atan22 / ceil;
            int i = 0;
            while (i < ceil) {
                double d36 = atan2 + d35;
                double sin4 = Math.sin(d36);
                double cos4 = Math.cos(d36);
                double d37 = d35;
                double d38 = (((d7 * cos2) * cos4) + d25) - (d29 * sin4);
                double d39 = d34;
                double d40 = d25;
                double d41 = (d39 * sin4) + (d7 * sin2 * cos4) + d26;
                double d42 = (d28 * sin4) - (d29 * cos4);
                double d43 = (cos4 * d39) + (sin4 * d31);
                double d44 = d36 - atan2;
                double tan = Math.tan(d44 / 2.0d);
                double sqrt3 = ((Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d) * Math.sin(d44)) / 3.0d;
                path.rLineTo(RecyclerView.f7068F0, RecyclerView.f7068F0);
                path.cubicTo((float) ((d30 * sqrt3) + d6), (float) ((d33 * sqrt3) + d11), (float) (d38 - (sqrt3 * d42)), (float) (d41 - (sqrt3 * d43)), (float) d38, (float) d41);
                i++;
                atan2 = d36;
                d31 = d31;
                cos2 = cos2;
                ceil = ceil;
                d33 = d43;
                d7 = d7;
                d30 = d42;
                d6 = d38;
                d11 = d41;
                d25 = d40;
                d35 = d37;
                d34 = d39;
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @Deprecated
        public static void nodesToPath(@NonNull PathDataNode[] pathDataNodeArr, @NonNull Path path) {
            PathParser.nodesToPath(pathDataNodeArr, path);
        }

        @NonNull
        public float[] getParams() {
            return this.f3638b;
        }

        public char getType() {
            return this.f3637a;
        }

        public void interpolatePathDataNode(@NonNull PathDataNode pathDataNode, @NonNull PathDataNode pathDataNode2, float f) {
            this.f3637a = pathDataNode.f3637a;
            int i = 0;
            while (true) {
                float[] fArr = pathDataNode.f3638b;
                if (i < fArr.length) {
                    this.f3638b[i] = (pathDataNode2.f3638b[i] * f) + ((1.0f - f) * fArr[i]);
                    i++;
                } else {
                    return;
                }
            }
        }

        public PathDataNode(PathDataNode pathDataNode) {
            this.f3637a = pathDataNode.f3637a;
            float[] fArr = pathDataNode.f3638b;
            this.f3638b = PathParser.m831a(fArr.length, fArr);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static boolean interpolatePathDataNodes(@NonNull PathDataNode[] pathDataNodeArr, @NonNull PathDataNode[] pathDataNodeArr2, @NonNull PathDataNode[] pathDataNodeArr3, float f) {
        if (pathDataNodeArr.length == pathDataNodeArr2.length && pathDataNodeArr2.length == pathDataNodeArr3.length) {
            if (!canMorph(pathDataNodeArr2, pathDataNodeArr3)) {
                return false;
            }
            for (int i = 0; i < pathDataNodeArr.length; i++) {
                pathDataNodeArr[i].interpolatePathDataNode(pathDataNodeArr2[i], pathDataNodeArr3[i], f);
            }
            return true;
        }
        throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes must have the same length");
    }
}
