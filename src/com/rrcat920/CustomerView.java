package com.rrcat920;

public class CustomerView {

    private final CustomerList customers = new CustomerList(10);

    public CustomerView() {
        var customer = new Customer("张三", '男', 30, "010-56253825",
                "abc@email.com");
        customers.addCustomer(customer);
    }

    public void enterMainMenu() {
        label: while (true) {
            System.out.println("-----------------客户信息管理软件-----------------\n");
            System.out.println("\t\t1 添 加 客 户");
            System.out.println("\t\t2 修 改 客 户");
            System.out.println("\t\t3 删 除 客 户");
            System.out.println("\t\t4 客 户 列 表");
            System.out.println("\t\t5 退       出");
            System.out.println();
            System.out.print("\t\t请选择(1-5)：");

            String key = Util.readMenuSelection();
            switch (key) {
                case "1" -> addCustomer();
                case "2" -> modifyCustomer();
                case "3" -> deleteCustomer();
                case "4" -> listCustomers();
                case "5" -> {
                    System.out.print("确认是否退出(Y/N)：");
                    String yes = Util.readConfirmation();
                    if (yes.equals("Y")) {
                        break label;
                    }
                }
            }
        }
    }

    private void listCustomers() {
        System.out.println("\n---------------------------客户列表---------------------------\n");
        System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t邮箱");
        for (int i = 0; i < customers.length(); i++) {
            Customer customer = customers.getCustomer(i);
            System.out.printf("%s\t%s\t%c\t%d\t%s\t%s%n",
                    i + 1, customer.getName(), customer.getGender(),
                    customer.getAge(), customer.getPhone(), customer.getEmail());
        }
        System.out.println("\n-------------------------客户列表完成-------------------------\n");
    }

    private void deleteCustomer() {
        System.out.println("\n---------------------删除客户---------------------\n");
        int index = Util.readCustomerIndex(customers, "请选择待删除的客户编号(-1退出)：");
        if (index == -1) return;
        customers.deleteCustomer(index - 1);
        System.out.println("\n---------------------删除完成---------------------\n");
    }

    private void modifyCustomer() {
        System.out.println("\n---------------------修改客户---------------------\n");

        int index = Util.readCustomerIndex(customers, "请选择待修改的客户编号(-1退出)：");
        if (index == -1) return;
        Customer customer = customers.getCustomer(index - 1);

        System.out.printf("姓名(%s)：", customer.getName());
        customer.setName(Util.readString(4, customer.getName()));

        System.out.printf("性别(%c)：", customer.getGender());
        customer.setGender(Util.readString(1, customer.getGender() + "").charAt(0));

        System.out.printf("年龄(%d)：", customer.getAge());
        customer.setAge(Util.readInt(customer.getAge()));

        System.out.printf("电话(%s)：", customer.getPhone());
        customer.setPhone(Util.readString(15, customer.getPhone()));

        System.out.printf("邮箱(%s)：", customer.getEmail());
        customer.setEmail(Util.readString(15, customer.getEmail()));

        customers.replaceCustomer(index - 1, customer);

        System.out.println("\n---------------------修改完成---------------------\n");
    }

    private void addCustomer() {
        System.out.println("\n---------------------添加客户---------------------\n");
        System.out.print("姓名：");
        String name = Util.readString(4);

        System.out.print("性别：");
        char gender = Util.readString(1).charAt(0);

        System.out.print("年龄：");
        int age = Util.readInt();

        System.out.print("电话：");
        String phone = Util.readString(15);

        System.out.print("邮箱：");
        String email = Util.readString(15);

        customers.addCustomer(new Customer(name, gender, age, phone, email));
        System.out.println("\n---------------------添加完成---------------------\n");
    }
}
