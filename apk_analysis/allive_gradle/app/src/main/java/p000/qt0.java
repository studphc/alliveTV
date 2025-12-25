package p000;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.R;
import androidx.fragment.app.C0264s;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.strictmode.FragmentStrictMode;

/* loaded from: classes.dex */
public final class qt0 implements LayoutInflater.Factory2 {

    /* renamed from: a */
    public final FragmentManager f25743a;

    public qt0(FragmentManager fragmentManager) {
        this.f25743a = fragmentManager;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        C0264s m1183g;
        boolean equals = FragmentContainerView.class.getName().equals(str);
        FragmentManager fragmentManager = this.f25743a;
        if (equals) {
            return new FragmentContainerView(context, attributeSet, fragmentManager);
        }
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Fragment);
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(R.styleable.Fragment_android_name);
        }
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.Fragment_android_id, -1);
        String string = obtainStyledAttributes.getString(R.styleable.Fragment_android_tag);
        obtainStyledAttributes.recycle();
        if (attributeValue != null) {
            try {
                z = Fragment.class.isAssignableFrom(FragmentFactory.m1148a(context.getClassLoader(), attributeValue));
            } catch (ClassNotFoundException unused) {
                z = false;
            }
            if (z) {
                int id = view != null ? view.getId() : 0;
                if (id == -1 && resourceId == -1 && string == null) {
                    throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
                }
                Fragment findFragmentById = resourceId != -1 ? fragmentManager.findFragmentById(resourceId) : null;
                if (findFragmentById == null && string != null) {
                    findFragmentById = fragmentManager.findFragmentByTag(string);
                }
                if (findFragmentById == null && id != -1) {
                    findFragmentById = fragmentManager.findFragmentById(id);
                }
                if (findFragmentById == null) {
                    findFragmentById = fragmentManager.getFragmentFactory().instantiate(context.getClassLoader(), attributeValue);
                    findFragmentById.f4462p = true;
                    findFragmentById.f4472z = resourceId != 0 ? resourceId : id;
                    findFragmentById.f4418A = id;
                    findFragmentById.f4419B = string;
                    findFragmentById.f4463q = true;
                    findFragmentById.f4468v = fragmentManager;
                    findFragmentById.f4469w = fragmentManager.getHost();
                    findFragmentById.onInflate(fragmentManager.getHost().getContext(), attributeSet, findFragmentById.f4446b);
                    m1183g = fragmentManager.m1175a(findFragmentById);
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "Fragment " + findFragmentById + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                    }
                } else if (!findFragmentById.f4463q) {
                    findFragmentById.f4463q = true;
                    findFragmentById.f4468v = fragmentManager;
                    findFragmentById.f4469w = fragmentManager.getHost();
                    findFragmentById.onInflate(fragmentManager.getHost().getContext(), attributeSet, findFragmentById.f4446b);
                    m1183g = fragmentManager.m1183g(findFragmentById);
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "Retained Fragment " + findFragmentById + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                    }
                } else {
                    throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
                }
                ViewGroup viewGroup = (ViewGroup) view;
                FragmentStrictMode.onFragmentTagUsage(findFragmentById, viewGroup);
                findFragmentById.f4427J = viewGroup;
                m1183g.m1240k();
                m1183g.m1239j();
                View view2 = findFragmentById.f4428K;
                if (view2 != null) {
                    if (resourceId != 0) {
                        view2.setId(resourceId);
                    }
                    if (findFragmentById.f4428K.getTag() == null) {
                        findFragmentById.f4428K.setTag(string);
                    }
                    findFragmentById.f4428K.addOnAttachStateChangeListener(new pt0(this, m1183g));
                    return findFragmentById.f4428K;
                }
                throw new IllegalStateException(ye0.m8296p("Fragment ", attributeValue, " did not create a view."));
            }
        }
        return null;
    }
}
