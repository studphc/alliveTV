package p000;

import com.hisona.allive.PlayerActivity;
import java.util.TimerTask;

/* loaded from: classes2.dex */
public final class c62 extends TimerTask {

    /* renamed from: a */
    public final /* synthetic */ PlayerActivity f8274a;

    public c62(PlayerActivity playerActivity) {
        this.f8274a = playerActivity;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        PlayerActivity playerActivity = this.f8274a;
        playerActivity.f15895X.cancel();
        playerActivity.f15898a0 = Boolean.FALSE;
        playerActivity.f15882K = playerActivity.f15881J;
        playerActivity.f15881J = playerActivity.f15896Y;
        playerActivity.m4463j();
    }
}
