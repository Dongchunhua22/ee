package com.example.dong;

public class Persener {
    private NetView view;
    private final Model model;

    public Persener(NetView view) {
        this.view = view;
        model = new Model();
    }

    public void getData() {
        model.getData(new MyCallBack() {


            @Override
            public void fail(String str) {

            }

            @Override
            public void success(Bean bean) {
                view.setData(bean.getData().getDatas());

            }
        });

    }
}
