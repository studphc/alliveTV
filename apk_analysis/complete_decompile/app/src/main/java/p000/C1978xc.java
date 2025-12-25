package p000;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.audio.AudioCapabilities;
import com.google.android.exoplayer2.audio.AudioCapabilitiesReceiver;

/* renamed from: xc */
/* loaded from: classes.dex */
public final class C1978xc extends ContentObserver {

    /* renamed from: a */
    public final ContentResolver f28503a;

    /* renamed from: b */
    public final Uri f28504b;

    /* renamed from: c */
    public final /* synthetic */ AudioCapabilitiesReceiver f28505c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1978xc(AudioCapabilitiesReceiver audioCapabilitiesReceiver, Handler handler, ContentResolver contentResolver, Uri uri) {
        super(handler);
        this.f28505c = audioCapabilitiesReceiver;
        this.f28503a = contentResolver;
        this.f28504b = uri;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        AudioCapabilitiesReceiver audioCapabilitiesReceiver = this.f28505c;
        AudioCapabilities capabilities = AudioCapabilities.getCapabilities(audioCapabilitiesReceiver.f9647a);
        if (audioCapabilitiesReceiver.f9653g && !capabilities.equals(audioCapabilitiesReceiver.f9652f)) {
            audioCapabilitiesReceiver.f9652f = capabilities;
            audioCapabilitiesReceiver.f9648b.onAudioCapabilitiesChanged(capabilities);
        }
    }
}
