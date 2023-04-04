<template>

    <v-card outlined>
        <v-card-title>
            AceeptorReject
        </v-card-title>

        <v-card-text>
            <Boolean label="Aceept" v-model="value.aceept" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="aceeptorReject"
            >
                AceeptorReject
            </v-btn>
            
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'AceeptorRejectCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.aceept = false;
        },
        watch: {
        },
        methods: {
            aceeptorReject() {
                this.$emit('aceeptorReject', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

