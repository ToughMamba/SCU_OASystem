package com.example.backend.entity.role;

public class RoleResponse {
    private int status;
    private String message;
    private boolean success;
    private Data data;

    public RoleResponse(int status, String message, boolean success, String roleName) {
        this.status = status;
        this.message = message;
        this.success = success;
        this.data = new Data(roleName);
    }

    // Getter 和 Setter 方法
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    // 内部类 Data
    public static class Data {
        private String roleName;

        public Data(String roleName) {
            this.roleName = roleName;
        }

        public String getRoleName() {
            return roleName;
        }

        public void setRoleName(String roleName) {
            this.roleName = roleName;
        }
    }
}
