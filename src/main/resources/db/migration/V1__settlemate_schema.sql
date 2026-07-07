create table merchants (
  id varchar(64) primary key,
  name varchar(120) not null,
  settlement_cycle varchar(32) not null,
  created_at timestamp not null default current_timestamp
);

create table settlement_runs (
  id varchar(64) primary key,
  merchant_id varchar(64) not null,
  gross_amount bigint not null,
  refund_amount bigint not null,
  payable_amount bigint not null,
  status varchar(32) not null,
  risk_signal varchar(64) not null,
  created_at timestamp not null default current_timestamp,
  constraint fk_settlement_runs_merchant foreign key (merchant_id) references merchants(id)
);

create index idx_settlement_runs_merchant_created
  on settlement_runs(merchant_id, created_at);
