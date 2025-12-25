package kotlin;

@Metadata(m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final /* synthetic */ class LazyKt__LazyJVMKt$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        int[] iArr = new int[LazyThreadSafetyMode.values().length];
        try {
            iArr[LazyThreadSafetyMode.SYNCHRONIZED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[LazyThreadSafetyMode.PUBLICATION.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr[LazyThreadSafetyMode.NONE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        $EnumSwitchMapping$0 = iArr;
    }
}
