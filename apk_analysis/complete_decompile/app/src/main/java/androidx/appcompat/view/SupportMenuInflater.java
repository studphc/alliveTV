package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.SubMenu;
import androidx.annotation.LayoutRes;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ActionProvider;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;
import p000.yq2;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class SupportMenuInflater extends MenuInflater {

    /* renamed from: e */
    public static final Class[] f803e;

    /* renamed from: f */
    public static final Class[] f804f;

    /* renamed from: a */
    public final Object[] f805a;

    /* renamed from: b */
    public final Object[] f806b;

    /* renamed from: c */
    public final Context f807c;

    /* renamed from: d */
    public Object f808d;

    static {
        Class[] clsArr = {Context.class};
        f803e = clsArr;
        f804f = clsArr;
    }

    public SupportMenuInflater(Context context) {
        super(context);
        this.f807c = context;
        Object[] objArr = {context};
        this.f805a = objArr;
        this.f806b = objArr;
    }

    /* renamed from: a */
    public static Object m206a(Object obj) {
        if (obj instanceof Activity) {
            return obj;
        }
        if (obj instanceof ContextWrapper) {
            return m206a(((ContextWrapper) obj).getBaseContext());
        }
        return obj;
    }

    /* renamed from: b */
    public final void m207b(XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Menu menu) {
        int i;
        char charAt;
        char charAt2;
        boolean z;
        yq2 yq2Var = new yq2(this, menu);
        int eventType = xmlResourceParser.getEventType();
        while (true) {
            i = 2;
            if (eventType == 2) {
                String name = xmlResourceParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlResourceParser.next();
                } else {
                    throw new RuntimeException("Expecting menu, got ".concat(name));
                }
            } else {
                eventType = xmlResourceParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        boolean z2 = false;
        boolean z3 = false;
        String str = null;
        while (!z2) {
            if (eventType != 1) {
                if (eventType != i) {
                    if (eventType == 3) {
                        String name2 = xmlResourceParser.getName();
                        if (z3 && name2.equals(str)) {
                            z3 = false;
                            str = null;
                        } else if (name2.equals("group")) {
                            yq2Var.f29080b = 0;
                            yq2Var.f29081c = 0;
                            yq2Var.f29082d = 0;
                            yq2Var.f29083e = 0;
                            yq2Var.f29084f = true;
                            yq2Var.f29085g = true;
                        } else if (name2.equals("item")) {
                            if (!yq2Var.f29086h) {
                                ActionProvider actionProvider = yq2Var.f29104z;
                                if (actionProvider != null && actionProvider.hasSubMenu()) {
                                    yq2Var.f29086h = true;
                                    yq2Var.m8316b(yq2Var.f29079a.addSubMenu(yq2Var.f29080b, yq2Var.f29087i, yq2Var.f29088j, yq2Var.f29089k).getItem());
                                } else {
                                    yq2Var.f29086h = true;
                                    yq2Var.m8316b(yq2Var.f29079a.add(yq2Var.f29080b, yq2Var.f29087i, yq2Var.f29088j, yq2Var.f29089k));
                                }
                            }
                        } else if (name2.equals("menu")) {
                            z2 = true;
                        }
                        eventType = xmlResourceParser.next();
                        i = 2;
                        z2 = z2;
                        z3 = z3;
                    }
                    eventType = xmlResourceParser.next();
                    i = 2;
                    z2 = z2;
                    z3 = z3;
                } else {
                    if (!z3) {
                        String name3 = xmlResourceParser.getName();
                        boolean equals = name3.equals("group");
                        SupportMenuInflater supportMenuInflater = yq2Var.f29078E;
                        if (equals) {
                            TypedArray obtainStyledAttributes = supportMenuInflater.f807c.obtainStyledAttributes(attributeSet, R.styleable.MenuGroup);
                            yq2Var.f29080b = obtainStyledAttributes.getResourceId(R.styleable.MenuGroup_android_id, 0);
                            yq2Var.f29081c = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_menuCategory, 0);
                            yq2Var.f29082d = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_orderInCategory, 0);
                            yq2Var.f29083e = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_checkableBehavior, 0);
                            yq2Var.f29084f = obtainStyledAttributes.getBoolean(R.styleable.MenuGroup_android_visible, true);
                            yq2Var.f29085g = obtainStyledAttributes.getBoolean(R.styleable.MenuGroup_android_enabled, true);
                            obtainStyledAttributes.recycle();
                        } else if (name3.equals("item")) {
                            TintTypedArray obtainStyledAttributes2 = TintTypedArray.obtainStyledAttributes(supportMenuInflater.f807c, attributeSet, R.styleable.MenuItem);
                            yq2Var.f29087i = obtainStyledAttributes2.getResourceId(R.styleable.MenuItem_android_id, 0);
                            yq2Var.f29088j = (obtainStyledAttributes2.getInt(R.styleable.MenuItem_android_menuCategory, yq2Var.f29081c) & SupportMenu.CATEGORY_MASK) | (obtainStyledAttributes2.getInt(R.styleable.MenuItem_android_orderInCategory, yq2Var.f29082d) & 65535);
                            yq2Var.f29089k = obtainStyledAttributes2.getText(R.styleable.MenuItem_android_title);
                            yq2Var.f29090l = obtainStyledAttributes2.getText(R.styleable.MenuItem_android_titleCondensed);
                            yq2Var.f29091m = obtainStyledAttributes2.getResourceId(R.styleable.MenuItem_android_icon, 0);
                            String string = obtainStyledAttributes2.getString(R.styleable.MenuItem_android_alphabeticShortcut);
                            if (string == null) {
                                charAt = 0;
                            } else {
                                charAt = string.charAt(0);
                            }
                            yq2Var.f29092n = charAt;
                            yq2Var.f29093o = obtainStyledAttributes2.getInt(R.styleable.MenuItem_alphabeticModifiers, 4096);
                            String string2 = obtainStyledAttributes2.getString(R.styleable.MenuItem_android_numericShortcut);
                            if (string2 == null) {
                                charAt2 = 0;
                            } else {
                                charAt2 = string2.charAt(0);
                            }
                            yq2Var.f29094p = charAt2;
                            yq2Var.f29095q = obtainStyledAttributes2.getInt(R.styleable.MenuItem_numericModifiers, 4096);
                            int i2 = R.styleable.MenuItem_android_checkable;
                            if (obtainStyledAttributes2.hasValue(i2)) {
                                yq2Var.f29096r = obtainStyledAttributes2.getBoolean(i2, false) ? 1 : 0;
                            } else {
                                yq2Var.f29096r = yq2Var.f29083e;
                            }
                            yq2Var.f29097s = obtainStyledAttributes2.getBoolean(R.styleable.MenuItem_android_checked, false);
                            yq2Var.f29098t = obtainStyledAttributes2.getBoolean(R.styleable.MenuItem_android_visible, yq2Var.f29084f);
                            yq2Var.f29099u = obtainStyledAttributes2.getBoolean(R.styleable.MenuItem_android_enabled, yq2Var.f29085g);
                            yq2Var.f29100v = obtainStyledAttributes2.getInt(R.styleable.MenuItem_showAsAction, -1);
                            yq2Var.f29103y = obtainStyledAttributes2.getString(R.styleable.MenuItem_android_onClick);
                            yq2Var.f29101w = obtainStyledAttributes2.getResourceId(R.styleable.MenuItem_actionLayout, 0);
                            yq2Var.f29102x = obtainStyledAttributes2.getString(R.styleable.MenuItem_actionViewClass);
                            String string3 = obtainStyledAttributes2.getString(R.styleable.MenuItem_actionProviderClass);
                            if (string3 != null) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z && yq2Var.f29101w == 0 && yq2Var.f29102x == null) {
                                yq2Var.f29104z = (ActionProvider) yq2Var.m8315a(string3, f804f, supportMenuInflater.f806b);
                            } else {
                                if (z) {
                                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                                }
                                yq2Var.f29104z = null;
                            }
                            yq2Var.f29074A = obtainStyledAttributes2.getText(R.styleable.MenuItem_contentDescription);
                            yq2Var.f29075B = obtainStyledAttributes2.getText(R.styleable.MenuItem_tooltipText);
                            int i3 = R.styleable.MenuItem_iconTintMode;
                            if (obtainStyledAttributes2.hasValue(i3)) {
                                yq2Var.f29077D = DrawableUtils.parseTintMode(obtainStyledAttributes2.getInt(i3, -1), yq2Var.f29077D);
                            } else {
                                yq2Var.f29077D = null;
                            }
                            int i4 = R.styleable.MenuItem_iconTint;
                            if (obtainStyledAttributes2.hasValue(i4)) {
                                yq2Var.f29076C = obtainStyledAttributes2.getColorStateList(i4);
                            } else {
                                yq2Var.f29076C = null;
                            }
                            obtainStyledAttributes2.recycle();
                            yq2Var.f29086h = false;
                        } else {
                            if (name3.equals("menu")) {
                                yq2Var.f29086h = true;
                                SubMenu addSubMenu = yq2Var.f29079a.addSubMenu(yq2Var.f29080b, yq2Var.f29087i, yq2Var.f29088j, yq2Var.f29089k);
                                yq2Var.m8316b(addSubMenu.getItem());
                                m207b(xmlResourceParser, attributeSet, addSubMenu);
                            } else {
                                str = name3;
                                z3 = true;
                            }
                            eventType = xmlResourceParser.next();
                            i = 2;
                            z2 = z2;
                            z3 = z3;
                        }
                    }
                    eventType = xmlResourceParser.next();
                    i = 2;
                    z2 = z2;
                    z3 = z3;
                }
            } else {
                throw new RuntimeException("Unexpected end of document");
            }
        }
    }

    @Override // android.view.MenuInflater
    public void inflate(@LayoutRes int i, Menu menu) {
        if (!(menu instanceof SupportMenu)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        boolean z = false;
        try {
            try {
                xmlResourceParser = this.f807c.getResources().getLayout(i);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xmlResourceParser);
                if (menu instanceof MenuBuilder) {
                    MenuBuilder menuBuilder = (MenuBuilder) menu;
                    if (menuBuilder.isDispatchingItemsChanged()) {
                        menuBuilder.stopDispatchingItemsChanged();
                        z = true;
                    }
                }
                m207b(xmlResourceParser, asAttributeSet, menu);
                if (z) {
                    ((MenuBuilder) menu).startDispatchingItemsChanged();
                }
                xmlResourceParser.close();
            } catch (IOException e) {
                throw new InflateException("Error inflating menu XML", e);
            } catch (XmlPullParserException e2) {
                throw new InflateException("Error inflating menu XML", e2);
            }
        } catch (Throwable th) {
            if (z) {
                ((MenuBuilder) menu).startDispatchingItemsChanged();
            }
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }
}
