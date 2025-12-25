package p000;

/* loaded from: classes2.dex */
public final /* synthetic */ class x10 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f28419a;

    /* renamed from: b */
    public final /* synthetic */ z10 f28420b;

    /* renamed from: c */
    public final /* synthetic */ Runnable f28421c;

    /* renamed from: d */
    public final /* synthetic */ b01 f28422d;

    public /* synthetic */ x10(z10 z10Var, Runnable runnable, b01 b01Var, int i) {
        this.f28419a = i;
        this.f28420b = z10Var;
        this.f28421c = runnable;
        this.f28422d = b01Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f28419a) {
            case 0:
                z10 z10Var = this.f28420b;
                z10Var.getClass();
                final b01 b01Var = this.f28422d;
                final Runnable runnable = this.f28421c;
                final int i = 0;
                z10Var.f29215a.execute(new Runnable() { // from class: v10
                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i) {
                            case 0:
                                try {
                                    runnable.run();
                                    return;
                                } catch (Exception e) {
                                    ((b20) b01Var.f7833b).setException(e);
                                    throw e;
                                }
                            case 1:
                                try {
                                    runnable.run();
                                    return;
                                } catch (Exception e2) {
                                    ((b20) b01Var.f7833b).setException(e2);
                                    return;
                                }
                            default:
                                Runnable runnable2 = runnable;
                                b20 b20Var = (b20) b01Var.f7833b;
                                try {
                                    runnable2.run();
                                    b20Var.set(null);
                                    return;
                                } catch (Exception e3) {
                                    b20Var.setException(e3);
                                    return;
                                }
                        }
                    }
                });
                return;
            case 1:
                z10 z10Var2 = this.f28420b;
                z10Var2.getClass();
                final b01 b01Var2 = this.f28422d;
                final Runnable runnable2 = this.f28421c;
                final int i2 = 2;
                z10Var2.f29215a.execute(new Runnable() { // from class: v10
                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i2) {
                            case 0:
                                try {
                                    runnable2.run();
                                    return;
                                } catch (Exception e) {
                                    ((b20) b01Var2.f7833b).setException(e);
                                    throw e;
                                }
                            case 1:
                                try {
                                    runnable2.run();
                                    return;
                                } catch (Exception e2) {
                                    ((b20) b01Var2.f7833b).setException(e2);
                                    return;
                                }
                            default:
                                Runnable runnable22 = runnable2;
                                b20 b20Var = (b20) b01Var2.f7833b;
                                try {
                                    runnable22.run();
                                    b20Var.set(null);
                                    return;
                                } catch (Exception e3) {
                                    b20Var.setException(e3);
                                    return;
                                }
                        }
                    }
                });
                return;
            default:
                z10 z10Var3 = this.f28420b;
                z10Var3.getClass();
                final b01 b01Var3 = this.f28422d;
                final Runnable runnable3 = this.f28421c;
                final int i3 = 1;
                z10Var3.f29215a.execute(new Runnable() { // from class: v10
                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i3) {
                            case 0:
                                try {
                                    runnable3.run();
                                    return;
                                } catch (Exception e) {
                                    ((b20) b01Var3.f7833b).setException(e);
                                    throw e;
                                }
                            case 1:
                                try {
                                    runnable3.run();
                                    return;
                                } catch (Exception e2) {
                                    ((b20) b01Var3.f7833b).setException(e2);
                                    return;
                                }
                            default:
                                Runnable runnable22 = runnable3;
                                b20 b20Var = (b20) b01Var3.f7833b;
                                try {
                                    runnable22.run();
                                    b20Var.set(null);
                                    return;
                                } catch (Exception e3) {
                                    b20Var.setException(e3);
                                    return;
                                }
                        }
                    }
                });
                return;
        }
    }
}
