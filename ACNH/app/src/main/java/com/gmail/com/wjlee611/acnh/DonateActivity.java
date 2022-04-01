package com.gmail.com.wjlee611.acnh;
package com.gmail.com.wjlee611.acnh.privateToken;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.anjlab.android.iab.v3.BillingProcessor;
import com.anjlab.android.iab.v3.Constants;
import com.anjlab.android.iab.v3.TransactionDetails;
import com.google.android.material.snackbar.Snackbar;

import java.util.Locale;


public class DonateActivity extends Activity implements BillingProcessor.IBillingHandler {

    private BillingProcessor bp;
    private AppStorage _storage;
    private com.gmail.com.wjlee611.acnh.privateToken.GoogleBillingToken GoogleBillingToken = new com.gmail.com.wjlee611.acnh.privateToken.GoogleBillingToken()

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donate);

        Button dlgBtnCancel = (Button) findViewById(R.id.btnDonateClose);
        Button btnDonate = (Button) findViewById(R.id.btnDonate);

        final AppStorage storage = new AppStorage(this);
        _storage = storage;
        bp = new BillingProcessor(this, GoogleBillingToken.myToken, this);
        bp.initialize();


        btnDonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (storage.purchasedDonate()) {
                    if (Locale.getDefault().getLanguage().equals("ko")) {
                        //한국어
                        Snackbar.make(findViewById(android.R.id.content), "이미 후원하셨습니다 :)", Snackbar.LENGTH_SHORT).show();
                    } else {
                        //default 영어
                        Snackbar.make(findViewById(android.R.id.content), "You've already donated :)", Snackbar.LENGTH_SHORT).show();
                    }
                } else {
                    bp.purchase(DonateActivity.this, "donate1000");
                }
            }
        });


        /*돌아가기*/
        dlgBtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onProductPurchased(String productId, TransactionDetails details) {
        if (productId.equals("donate1000")) {
            _storage.setPurchasedDonate(bp.isPurchased("donate1000"));
        }

        bp.consumePurchase("donate1000");
    }

    @Override
    public void onPurchaseHistoryRestored() {
        _storage.setPurchasedDonate(bp.isPurchased("donate1000"));
    }

    @Override
    public void onBillingError(int errorCode, Throwable error) {
        if (errorCode != Constants.BILLING_RESPONSE_RESULT_USER_CANCELED) {
            if (Locale.getDefault().getLanguage().equals("ko")) {
                //한국어
                Snackbar.make(findViewById(android.R.id.content), "구매 실패", Snackbar.LENGTH_SHORT).show();
            } else {
                //default 영어
                Snackbar.make(findViewById(android.R.id.content), "Fail to purchase", Snackbar.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onBillingInitialized() {
        _storage.setPurchasedDonate(bp.isPurchased("donate1000"));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!bp.handleActivityResult(requestCode, resultCode, data)) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onDestroy() {
        if (bp != null) {
            bp.release();
        }
        super.onDestroy();
    }
}
