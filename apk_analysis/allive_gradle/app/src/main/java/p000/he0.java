package p000;

import com.google.firebase.installations.remote.InstallationResponse;
import com.google.firebase.installations.remote.TokenResult;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class he0 {

    /* renamed from: a */
    public static final /* synthetic */ int[] f18038a;

    /* renamed from: b */
    public static final /* synthetic */ int[] f18039b;

    static {
        int[] iArr = new int[TokenResult.ResponseCode.values().length];
        f18039b = iArr;
        try {
            iArr[TokenResult.ResponseCode.f15622OK.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f18039b[TokenResult.ResponseCode.BAD_CONFIG.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f18039b[TokenResult.ResponseCode.AUTH_ERROR.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        int[] iArr2 = new int[InstallationResponse.ResponseCode.values().length];
        f18038a = iArr2;
        try {
            iArr2[InstallationResponse.ResponseCode.f15620OK.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f18038a[InstallationResponse.ResponseCode.BAD_CONFIG.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
