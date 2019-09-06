package org.papaja.adminfly.module.mdbv.mysql.entity;

import javax.persistence.*;

@Entity
@DiscriminatorValue("S")
public class ShortRow extends Row { }
