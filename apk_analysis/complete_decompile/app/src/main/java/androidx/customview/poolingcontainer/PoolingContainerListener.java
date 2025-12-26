package androidx.customview.poolingcontainer;

import androidx.annotation.UiThread;
import kotlin.Metadata;

@Metadata(m5568d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'¨\u0006\u0004"}, m5569d2 = {"Landroidx/customview/poolingcontainer/PoolingContainerListener;", "", "onRelease", "", "customview-poolingcontainer_release"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public interface PoolingContainerListener {
    @UiThread
    void onRelease();
}
