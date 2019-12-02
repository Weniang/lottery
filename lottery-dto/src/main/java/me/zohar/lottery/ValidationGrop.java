package me.zohar.lottery;

import javax.validation.GroupSequence;

public interface ValidationGrop {
    public interface UserGroup {
        @GroupSequence({ADD.USERNAME.class, ADD.LOGINPWD.class,ADD.QQNUMBER.class})
        interface ADD {
            @GroupSequence({UserGroup.ADD.USERNAME.NOTBLANK.class, UserGroup.ADD.USERNAME.LENGTH.class, UserGroup.ADD.USERNAME.PATTERN.class})
            interface USERNAME {
                interface PATTERN {
                }

                interface LENGTH {
                }

                interface NOTBLANK {
                }
            }

            @GroupSequence({UserGroup.ADD.LOGINPWD.NOTBLANK.class, UserGroup.ADD.LOGINPWD.LENGTH.class, UserGroup.ADD.LOGINPWD.PATTERN.class})
            interface LOGINPWD {
                interface PATTERN {
                }

                interface LENGTH {
                }

                interface NOTBLANK {
                }
            }

            @GroupSequence({UserGroup.ADD.QQNUMBER.NOTBLANK.class, UserGroup.ADD.QQNUMBER.LENGTH.class, UserGroup.ADD.QQNUMBER.PATTERN.class})
            interface QQNUMBER {
                interface PATTERN {
                }

                interface LENGTH {
                }

                interface NOTBLANK {
                }
            }
        }

        interface UPDATE {
            @GroupSequence({UserGroup.UPDATE.QQNUMBER.NOTBLANK.class, UserGroup.UPDATE.QQNUMBER.LENGTH.class, UserGroup.UPDATE.QQNUMBER.PATTERN.class})
            interface QQNUMBER {
                interface PATTERN {
                }

                interface LENGTH {
                }

                interface NOTBLANK {
                }
            }

            @GroupSequence({UserGroup.UPDATE.NICKNAME.NOTBLANK.class, UserGroup.UPDATE.NICKNAME.LENGTH.class, UserGroup.UPDATE.NICKNAME.PATTERN.class})
            interface NICKNAME {
                interface PATTERN {
                }

                interface LENGTH {
                }

                interface NOTBLANK {
                }
            }
        }
    }

    @GroupSequence({UserGroup.ADD.USERNAME.class, UserGroup.ADD.LOGINPWD.class, UserGroup.ADD.QQNUMBER.class})
    public interface UserCheckSequence {

    }
}
