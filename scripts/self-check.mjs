import { existsSync, readFileSync } from 'node:fs';

const required = [
  'build.gradle.kts',
  'src/main/kotlin/io/settlemate/SettleMateApplication.kt',
  'src/main/kotlin/io/settlemate/reconcile/ReconcileController.kt',
  'src/main/kotlin/io/settlemate/reconcile/ReconcileService.kt',
  'src/main/kotlin/io/settlemate/reconcile/MerchantCache.kt',
  'src/main/kotlin/io/settlemate/reconcile/SettlementEventPublisher.kt',
  'src/main/kotlin/io/settlemate/common/RequestLoggingFilter.kt',
  'src/main/resources/db/migration/V1__settlemate_schema.sql',
  'src/test/kotlin/io/settlemate/reconcile/ReconcileServiceTest.kt',
  'openapi.yaml'
];

for (const file of required) {
  if (!existsSync(file)) throw new Error(`missing ${file}`);
}

const gradle = readFileSync('build.gradle.kts', 'utf8');
for (const token of ['spring-boot-starter-web', 'spring-boot-starter-data-redis', 'spring-boot-starter-amqp']) {
  if (!gradle.includes(token)) throw new Error(`missing ${token}`);
}

const openapi = readFileSync('openapi.yaml', 'utf8');
if (!openapi.includes('/api/settlements')) throw new Error('openapi missing settlements endpoint');

const schema = readFileSync('src/main/resources/db/migration/V1__settlemate_schema.sql', 'utf8');
if (!schema.includes('settlement_runs')) throw new Error('schema missing settlement_runs');

for (const file of ['build.gradle.kts', 'openapi.yaml']) {
  if (readFileSync(file, 'utf8').toLowerCase().includes('graphql')) {
    throw new Error(`graphql must not be used: ${file}`);
  }
}

console.log('settlemate-be_self_check_ok');
